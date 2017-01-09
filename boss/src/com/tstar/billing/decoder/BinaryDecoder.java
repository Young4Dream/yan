/**
 * 
 */
package com.tstar.billing.decoder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.tstar.ocs.model.Cdr;
import com.tstar.util.BeanHelper;
import com.tstar.util.ByteHelper;
import com.tstar.util.FileHelper;
import com.tstar.util.RegExp;

/**
 * @author zhumengfeng
 * 
 */
public class BinaryDecoder implements IDecoder {

	private Integer startPos;

	public void setStartPos(int pos) {
		startPos = pos;
	}

	public List<Cdr> decode(byte[] content, DecoderConfig config)
			throws Exception {
		assert (config != null);
		assert (config.size > 0);
		int totalLength = content.length;
		if (totalLength <= 0)
			return null;
		int start = (startPos == null ? config.headerSize : startPos);
		int count = (totalLength - start) / config.size;
		if ((totalLength - config.headerSize) % config.size != 0
				|| (start - config.headerSize) % config.size != 0) {
			throw new Exception("Format error.");
		}
		List<Cdr> cdrs = new ArrayList<Cdr>();
		for (int i = 0; i < count; i++) {
			Cdr cdr = new Cdr();
			Iterator iter = config.nodes.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				DecoderConfigLeaf leaf = (DecoderConfigLeaf) entry.getValue();
				int pos = start + Integer.parseInt(leaf.tag);
				Object val = ByteHelper.Bytes2Object(content, pos, leaf.size,
						leaf.dataType);
				if (val != null) {
					Object value;
					if (leaf.pattern == null) {
						value = val;
					} else {
						value = RegExp.getValue(leaf.pattern, (String) val,
								leaf.patternIndex);
					}
					BeanHelper.setProperty(cdr, leaf.field, value);
				}
			}
			cdr.setServiceAbbr(config.category);
			if (cdr.getStartTime() == null
					&& (cdr.getEndTime() != null && cdr.getDuration() != null)) {
				cdr.setStartTime(new Date(cdr.getEndTime().getTime() - 1000
						* cdr.getDuration()));
			}
			cdrs.add(cdr);
			start += config.size;
		}
		String decodeName = config.name;
		if (decodeName.equalsIgnoreCase("ZTE")) {
			// 调用ZTEFilter
			ZTEFilter zf = new ZTEFilter();
			zf.filt(cdrs);
		} else if (decodeName.equalsIgnoreCase("mgcf")) {
			MgcfFilter mf = new MgcfFilter();
			mf.filt(cdrs);
		} else if (decodeName.equalsIgnoreCase("ats")) {
			AtsFilter mf = new AtsFilter();
			mf.filt(cdrs);
		}
		return cdrs;
	}

	public List<Cdr> decode(String filePath, DecoderConfig config)
			throws Exception {
		byte[] content = FileHelper.copyFile(filePath);
		if (content == null)
			return null;
		return decode(content, config);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long t1 = (new Date()).getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// byte[] content =
		// FileHelper.copyFile("E:/cdr/source/CC08_66\\20161211.BIL");
		byte[] content = FileHelper.copyFile("E:/cdr/source/ZTE\\HD161221.T00");
		System.out.println("fileSize=" + content.length);
		// 0031322 32310030313 30303 33, 0000000000000000000000000000,
		// 0002-11-30 00:00:00, 0002-11-30 00:00:00, duration=0,
		// trunkGroupIn=0000, trunkGroupOut=0000
		BinaryDecoder decoder = new BinaryDecoder();
		try {
			String decoderName = "ZTE";
			Map<String, DecoderConfig> decoders = XMLDecoderConfig
					.load("e:\\src\\boss\\config\\decoders.xml");
			DecoderConfig config = decoders.get(decoderName);
			if (config == null) {
				throw new Exception("Can not find decoder config.");
			}
			decoder.setStartPos(118 * 0);
			List<Cdr> cdrs = decoder.decode(content, config);
			long t2 = (new Date()).getTime();
			int count = 0;
			// ZTEFilter zf = new ZTEFilter();
			// zf.filt(cdrs);
			for (Cdr cdr : cdrs) {
				System.out.println(cdr.getCaller() + ", " + cdr.getCallee()
						+ ", " + sdf.format(cdr.getStartTime()) + ", "
						+ sdf.format(cdr.getEndTime())
						// + cdr.getBillId() + ", " + cdr.getLogId()
						+ ", duration=" + cdr.getDuration()
						// + "," + cdr.getLogId()
						+ ", trunkGroupIn=" + cdr.getTrunkGroupIn()
						+ ", trunkGroupOut=" + cdr.getTrunkGroupOut());
				count++;
				if (count > 50)
					break;
			}
			System.out.print("size=" + cdrs.size() + ", duration=" + (t2 - t1)
					+ " ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
