/**
 * 
 */
package com.tstar.billing.decoder;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.tstar.billing.pricer.INumberFormatter;
import com.tstar.billing.pricer.IPricer;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.Log;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
public class XMLDecoderConfig {

	private static Map<String, DecoderConfig> configs = null;
	private static final String CONFIG_FILENAME = System.getProperty("user.dir") + System.getProperty("file.separator") + "config" + System.getProperty("file.separator") + "decoders.xml";
	private static Map<String, IDecoder> decoders = null;
	private static Map<String, IPricer> pricers = null;
	private static Map<String, INumberFormatter> formatters = null;
	private static Map<String, IFilter> filters = null;
	
	public static DecoderConfig getDecoderConfig(String name) {
		try {
			if (configs == null) {
				configs = load(CONFIG_FILENAME);
			}
			return configs.get(name);
		} catch (Exception e) {
			Log.getLogger().error(ExceptionUtil.getStackTrace(e));
			return null;
		}
	}
	
	public static IDecoder getDecoder(String name) {
		try {
			if (configs == null) {
				configs = load(CONFIG_FILENAME);
			}
			return decoders.get(name);
		} catch (Exception e) {
			Log.getLogger().error(ExceptionUtil.getStackTrace(e));
			return null;
		}
	}
	
	public static IPricer getPricer(String name) {
		if (name == null) return null;
		try {
			if (configs == null) {
				configs = load(CONFIG_FILENAME);
			}
			return pricers.get(name);
		} catch (Exception e) {
			Log.getLogger().error(ExceptionUtil.getStackTrace(e));
			return null;
		}
	}
	
	public static INumberFormatter getNumberFormatter(String name) {
		if (name == null) return null;
		try {
			if (configs == null) {
				configs = load(CONFIG_FILENAME);
			}
			return formatters.get(name);
		} catch (Exception e) {
			Log.getLogger().error(ExceptionUtil.getStackTrace(e));
			return null;
		}
	}
	
	public static IFilter getFilter(String name) {
		if (name == null) return null;
		try {
			if (configs == null) {
				configs = load(CONFIG_FILENAME);
			}
			return filters.get(name);
		} catch (Exception e) {
			Log.getLogger().error(ExceptionUtil.getStackTrace(e));
			return null;
		}
	}
	
	public static Map<String, DecoderConfig> load(String filename) throws Exception {
		File file = new File(filename);
		if (!file.exists()) {
			throw new Exception(filename + " does not exists.");
		}
		FileInputStream fis = new FileInputStream(file);
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(fis);
		Element root = document.getRootElement();
		List<Element> children = root.elements();
		Map<String, DecoderConfig> confs = new ConcurrentHashMap<String, DecoderConfig>();
		decoders = new ConcurrentHashMap<String, IDecoder>();
		pricers = new ConcurrentHashMap<String, IPricer>();
		formatters = new ConcurrentHashMap<String, INumberFormatter>();
		filters = new ConcurrentHashMap<String, IFilter>();
		for (Element child : children) {
			// Parse root
			DecoderConfig decoder = new DecoderConfig();
			decoder.name = child.attributeValue("name");
			decoder.className = child.attributeValue("class");
			try { decoder.pricer = child.attributeValue("pricer"); } catch (Exception e) {}
			try { decoder.formatter = child.attributeValue("numberFormatter"); } catch (Exception e) {}
			try { decoder.filter = child.attributeValue("filter"); } catch (Exception e) {}
			try {
				IDecoder instance = (IDecoder)Class.forName(decoder.className).newInstance();
				decoders.put(decoder.className, instance);
				if (decoder.pricer != null && !"".equals(decoder.pricer)) {
					IPricer pricer = (IPricer)Class.forName(decoder.pricer).newInstance();
					pricers.put(decoder.pricer, pricer);
				}
				if (decoder.formatter != null && !"".equals(decoder.formatter)) {
					INumberFormatter formatter = (INumberFormatter)Class.forName(decoder.formatter).newInstance();
					formatters.put(decoder.formatter, formatter);
				}
				if (!StringUtil.isEmpty(decoder.filter)) {
					IFilter filter = (IFilter)Class.forName(decoder.filter).newInstance();
					filters.put(decoder.filter, filter);
				}
			} catch (Exception e) {
				e.printStackTrace();
				Log.getLogger().error("Unable to load the class, name=" + decoder.className);
			}
			decoder.tag = child.attributeValue("tag");
			try {decoder.category = child.attributeValue("business");} catch (Exception e) {}
			String sizeStr = child.attributeValue("size");
			if (sizeStr != null && !"".equals(sizeStr)) {
				decoder.size = Integer.parseInt(sizeStr);
			}
			try { decoder.headerSize = Integer.parseInt(child.attributeValue("headerSize")); } catch (Exception e) { decoder.headerSize = 0; };
			
			decoder.fieldCount = 0;
			//decoder.nodes = new HashMap<String, IDecoderConfigNode>();
			decoder.nodes = new ConcurrentHashMap<String, IDecoderConfigNode>();
			
			// Parse trunk and sub leaves
			List<Element> trunks = child.elements("trunk");
			for (Element trunk : trunks) {
				DecoderConfigTrunk node = new DecoderConfigTrunk();
				node.tag = trunk.attributeValue("tag");
				node.action = trunk.attributeValue("action");
				node.className = trunk.attributeValue("class");
				node.business = trunk.attributeValue("business");
				node.field = trunk.attributeValue("field");
				node.nodes = new ConcurrentHashMap<String, IDecoderConfigNode>();
				List<Element> subchildren = trunk.elements("leaf");
				for (Element leaf : subchildren) {
					DecoderConfigLeaf leafNode = new DecoderConfigLeaf();
					leafNode.tag = leaf.attributeValue("tag");
					leafNode.field = leaf.attributeValue("field");
					String leafSizeStr = leaf.attributeValue("size");
					if (leafSizeStr != null && !"".equals(leafSizeStr)) {
						leafNode.size = Integer.parseInt(leafSizeStr);
					}
					leafNode.dataType = leaf.attributeValue("datatype");
					leafNode.format = leaf.attributeValue("format");
					leafNode.source = leaf.attributeValue("source");
					leafNode.pattern = leaf.attributeValue("pattern");
					leafNode.ifexp = leaf.attributeValue("ifexp");
					leafNode.ifval = leaf.attributeValue("ifval");
					String tmp = leaf.attributeValue("patternIndex");
					if (tmp != null && !tmp.equals("")) {
						leafNode.patternIndex = Integer.parseInt(tmp);
					}
					node.nodes.put(leafNode.tag, leafNode);
				}
				decoder.fieldCount += subchildren.size();
				decoder.nodes.put(node.tag, node);
			}
			// Parse leaves
			List<Element> leaves = child.elements("leaf");
			for (Element leaf : leaves) {
				DecoderConfigLeaf node = new DecoderConfigLeaf();
				node.tag = leaf.attributeValue("tag");
				node.field = leaf.attributeValue("field");
				String leafSizeStr = leaf.attributeValue("size");
				if (leafSizeStr != null && !"".equals(leafSizeStr)) {
					node.size = Integer.parseInt(leafSizeStr);
				}
				node.dataType = leaf.attributeValue("datatype");
				node.format = leaf.attributeValue("format");
				node.source = leaf.attributeValue("source");
				node.pattern = leaf.attributeValue("pattern");
				node.ifexp = leaf.attributeValue("ifexp");
				node.ifval = leaf.attributeValue("ifval");
				String tmp = leaf.attributeValue("patternIndex");
				if (tmp != null && !tmp.equals("")) {
					node.patternIndex = Integer.parseInt(tmp);
				}
				decoder.nodes.put(node.tag, node);
			}
			decoder.fieldCount += leaves.size();
			confs.put(decoder.name, decoder);
		}
		return confs;
	}
	
	public static List<String> getDecoders(String filename) throws Exception {
		File file = new File(filename);
		if (!file.exists()) {
			throw new Exception(filename + " does not exists.");
		}
		FileInputStream fis = new FileInputStream(file);
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(fis);
		Element root = document.getRootElement();
		List<Element> children = root.elements();
		List<String> decoders = new ArrayList<String>();
		for (Element child : children) {
			decoders.add(child.attributeValue("name"));
		}
		return decoders;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			List<String> decoderList = getDecoders("e:\\src\\Caas\\config\\decoders.xml");
			for (String name : decoderList) {
				System.out.print("decoder name=" + name + "\n");
			}
			
			Map<String, DecoderConfig> decoders = load("e:\\src\\Caas\\config\\decoders.xml");
			Iterator iter = decoders.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry)iter.next();
				DecoderConfig obj = (DecoderConfig)entry.getValue();
				System.out.print("name=" + obj.name + ",class=" + obj.className + ",tag=" + obj.tag + ",size=" + obj.size + ",fieldcount=" + obj.fieldCount + "\n");
				Iterator iter1 = obj.nodes.entrySet().iterator();
				while (iter1.hasNext()) {
					Map.Entry element = (Map.Entry)iter1.next();
					IDecoderConfigNode node = (IDecoderConfigNode)element.getValue();
					if (node instanceof DecoderConfigLeaf) {
						DecoderConfigLeaf leaf = (DecoderConfigLeaf)node;
						System.out.print(obj.name + ".tag(leaf)=" + leaf.tag + ", field=" + leaf.field + ", size=" + leaf.size + ", datatype=" + leaf.dataType + "\n");
					} else if (node instanceof DecoderConfigTrunk) {
						DecoderConfigTrunk trunk = (DecoderConfigTrunk)node;
						System.out.print(obj.name + ".tag(trunk)=" + trunk.tag + ", action=" + trunk.action + ", business=" + trunk.business + "\n");
						Iterator iter2 = trunk.nodes.entrySet().iterator();
						while (iter2.hasNext()) {
							Map.Entry e = (Map.Entry)iter2.next();
							DecoderConfigLeaf subnode = (DecoderConfigLeaf)e.getValue();
							System.out.print(obj.name + "." + trunk.tag + ".tag=" +subnode.tag + ", field=" + subnode.field + ", size=" + subnode.size + ", datatype=" + subnode.dataType + "\n");
						}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
