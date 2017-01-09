package com.tstar.billing.decoder;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.tstar.ocs.model.Cdr;
import com.tstar.util.BeanHelper;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.FileHelper;
import com.tstar.util.Log;
import com.tstar.util.RegExp;

public class XMLDecoder implements IDecoder {

	private static final String FILE_HEAD = "<CDRS>";
	private static final String FILE_TAIL = "</CDRS>";
	
	private static Map<String, ISubDecoder> subDecoders = new ConcurrentHashMap<String, ISubDecoder>();
	
	public void setStartPos(int pos) {}
	
	private static ISubDecoder getSubDecoder(String className) throws Exception {
		ISubDecoder obj = subDecoders.get(className);
		if (obj == null) {
			obj = (ISubDecoder)Class.forName(className).newInstance(); 
			subDecoders.put(className, obj);
		}
		return obj;
	}

	public List<Cdr> decode(byte[] content, DecoderConfig config) throws Exception {
		SAXReader saxReader = new SAXReader();
		InputStream in = new ByteArrayInputStream(content);
		Document document = saxReader.read(in);
		
		Element root = document.getRootElement();
		List<Element> children = root.elements(config.tag);
		List<Cdr> cdrs = new ArrayList<Cdr>();
		Map<String, IDecoderConfigNode> nodes = config.nodes; //(HashMap<String, IDecoderConfigNode>)((HashMap<String, IDecoderConfigNode>)config.nodes).clone();
		for (Element child : children) {
			Cdr cdr = new Cdr();
			//cdr.business = config.category;
			//Iterator iter = config.nodes.entrySet().iterator();
			Iterator iter = nodes.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry)iter.next();
				IDecoderConfigNode node = (IDecoderConfigNode)entry.getValue();
				if (node instanceof DecoderConfigLeaf) {
					DecoderConfigLeaf leaf = (DecoderConfigLeaf)node;
					try {
						String tag = (leaf.source == null || leaf.source.equals("")) ? leaf.tag : leaf.source;
						String val = child.element(tag).getText();
						if (val == null || "".equals(val)) {
							System.out.println("error, tag=" + tag + ", leaf.field=" + leaf.field);
						}
						String value;
						if (leaf.pattern == null) {
							value = val;
						} else {
							value = RegExp.getValue(leaf.pattern, val, leaf.patternIndex);
						}
						BeanHelper.setPropertyFromStr(cdr, leaf.field, value);
						//System.out.println("leaf.tag=" + leaf.tag + ", leaf.field=" + leaf.field + ", value=" + val);
					} catch (Exception e) {
						Log.getLogger().warn("Tag=" + leaf.tag + ", Message=" + ExceptionUtil.getStackTrace(e));
						//Log.getLogger().warn("Can't parse cdr field, tag=" + leaf.tag + ", field=" + leaf.field);
					}
				} 
			} 
			cdrs.add(cdr);
			
			//iter = config.nodes.entrySet().iterator();
			iter = nodes.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry)iter.next();
				IDecoderConfigNode node = (IDecoderConfigNode)entry.getValue();
				if (node instanceof DecoderConfigTrunk) {
					DecoderConfigTrunk trunk = (DecoderConfigTrunk)node;
					if (trunk.action != null && trunk.action.equals("new")) {
						if (trunk.className == null || "".equals(trunk.className)) {
							// XML format sub cdr
							Element subRoot = child.element(trunk.tag); 
							if (subRoot != null) {
								List<Element> subChildren = subRoot.elements();
								for (Element subChild : subChildren) {
									Cdr subCdr = new Cdr();
									Iterator iter1 = trunk.nodes.entrySet().iterator();
									while (iter1.hasNext()) {
										Map.Entry subEntry = (Map.Entry)iter1.next();
										DecoderConfigLeaf subLeaf = (DecoderConfigLeaf)subEntry.getValue();
										String tmp = subChild.element(subLeaf.tag).getText();
										String value;
										if (subLeaf.pattern == null) {
											value = tmp;
										} else {
											value = RegExp.getValue(subLeaf.pattern, tmp, subLeaf.patternIndex);
										}
										BeanHelper.setPropertyFromStr(cdr, subLeaf.field, value);
									}
									if (subCdr.getDuration() > 0) {
										cdrs.add(subCdr);
									}
								}
							} // for (Element subChild : subChildren) {
						} else {
							Element e = child.element(trunk.tag);
							if (e != null) {
								ISubDecoder subDecoder = getSubDecoder(trunk.className);
								String subContent = e.getText();
								if (subContent != null && !"".equals(subContent)) {
									List<Cdr> subCdrs = subDecoder.decode(subContent, trunk, cdr);
									for (Cdr c : subCdrs) {
										if (c.getDuration() > 0) {
											cdrs.add(c);
										}
									}
								}
							}
						}
					} // if (trunk.sub)
				} // if (node instanceof DecoderConfigTrunk)
			} // while (iter.hasNext()) {
		} // for
		
		return cdrs;
	}

	public List<Cdr> decode(String filePath, DecoderConfig config) throws Exception {
		byte[] content = FileHelper.copyFile(filePath, FILE_HEAD, FILE_TAIL);
		if (content == null) return null;
		return decode(content, config);
	}

}
