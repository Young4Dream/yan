/**
 * 
 */
package com.tstar.billing.decoder;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tstar.ocs.model.Cdr;
import com.tstar.util.ByteHelper;
import com.tstar.util.FileHelper;

/**
 * @author zhumengfeng
 *
 */
public class EwsdDecoder implements IDecoder {
	
	private static final DecimalFormat df = new DecimalFormat("00");
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public void setStartPos(int pos) { }
	
	public List<Cdr> decode(byte[] content, DecoderConfig config) throws Exception {
		assert(config != null);
		assert(config.size > 0);
		assert(content != null && content.length > 0);
		List<Cdr> cdrs = new ArrayList<Cdr>();
		int pos = 0;
		int cdrStartPos = 0;
		int lastPos = content.length - 1;
		System.out.println("content.length=" + content.length);
		while (cdrStartPos < lastPos) {
			// 记录类型，0x84为计费详单
			pos = cdrStartPos;
			int cdrType = ByteHelper.Bytes2Int(content, pos, 1);
			//System.out.println("cdrType=" + cdrType);
			// 记录长度
			pos++;
			//int cdrLen = ByteHelper.Bytes2Int(content, pos, 2);
			int cdrLen = ByteHelper.LEBytes2Int(content, pos, 2);
			//System.out.println("cdrLen=" + cdrLen);
			// Next cdr start position
			cdrStartPos += cdrLen;
			// TAG=0x84
			if (cdrType != 132) continue;
			// 记录标识
			pos += 2;
			//int cdrFlag = ByteHelper.Bytes2Int(content, pos, 3);
			//System.out.println("cdrFlag=" + cdrFlag);
			pos += 3;
			// 记录系列及计费状态
			int billingFlag = ByteHelper.Bytes2Int(content, pos, 1);
			if (1 != (billingFlag & 0x0f)) continue;
			
			Cdr cdr = new Cdr();
			
			pos += 1;
			// 主叫号码
			// 主叫号码长度
			int callerCount = 0x1F & content[pos];
			//System.out.println("caller.count=" + callerCount);
			pos += 1;
			int callerLen = callerCount / 2 + ( callerCount % 2 == 1 ? 1 : 0);
			//System.out.println("caller.len=" + callerLen);
			String caller = ByteHelper.Bytes2HexString(content, pos, callerLen, callerCount);
			pos += callerLen;
			//System.out.println("caller=" + caller);
			cdr.setCaller(caller);
			// 呼始、呼止时间、通话时长
			int timeTag = ByteHelper.Bytes2Int(content, pos, 1);
			//System.out.println("timeTag=" + timeTag);
			if (timeTag != 100) {
				continue;
			}
			// Year
			pos += 1;
			int year = ByteHelper.Bytes2Int(content, pos, 1);
			pos += 1;
			int month = ByteHelper.Bytes2Int(content, pos, 1);
			pos += 1;
			int day = ByteHelper.Bytes2Int(content, pos, 1);
			pos += 1;
			int hour = ByteHelper.Bytes2Int(content, pos, 1);
			pos += 1;
			int minute = ByteHelper.Bytes2Int(content, pos, 1);
			pos++;
			int second = ByteHelper.Bytes2Int(content, pos, 1);
			pos++;
			int timeFlag = ByteHelper.Bytes2Int(content, pos, 1);
			pos++;
			int duration = ByteHelper.LEBytes2Int(content, pos, 3);
			String timeStr = "20" + df.format(year) + "-" + df.format(month) + "-" + df.format(day) +
							" " + df.format(hour) + ":" + df.format(minute) + ":" + df.format(second);
			Date time = sdf.parse(timeStr);
			//System.out.println("time=" + timeStr);
			//System.out.println("timeFlag=" + timeFlag);
			if (0 == (0x04 & timeFlag)) {
				//System.out.println("startTime");
				cdr.setStartTime(time);
				Date anotherTime = new Date(time.getTime() + duration * 1000);
				cdr.setEndTime(anotherTime);
			} else {
				//System.out.println("endTime");
				cdr.setEndTime(time);
				Date anotherTime = new Date(time.getTime() - duration * 1000);
				cdr.setStartTime(anotherTime);
			}
			//System.out.println("duration=" + duration);
			cdr.setDuration(duration);
			// 被叫号码
			pos += 3;
			int calleeTag = ByteHelper.Bytes2Int(content, pos, 1);
			//System.out.println("calleeTag=" + calleeTag);
			if (calleeTag != 101) {
				continue;
			}
			pos++;
			int calleeCount = 0x1F & content[pos];
			//System.out.println("callee.count=" + calleeCount);
			pos += 1;
			int calleeLen = calleeCount / 2 + ( calleeCount % 2 == 1 ? 1 : 0);
			//System.out.println("callee.len=" + calleeLen);
			String callee = ByteHelper.Bytes2HexString(content, pos, calleeLen, calleeCount);
			pos += calleeLen;
			//System.out.println("callee=" + callee);
			cdr.setCallee(callee);
			cdrs.add(cdr);
		}
		return cdrs;
	}
	
	public List<Cdr> decode(String filePath, DecoderConfig config) throws Exception {
		byte[] content = FileHelper.copyFile(filePath);
		if (content == null) return null;
		return decode(content, config);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long t1 = (new Date()).getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		byte[] content = FileHelper.copyFile("E:\\cdr\\source\\EWSD\\161214N0.AMA");
		System.out.println("fileSize=" + content.length);
		IDecoder decoder = new EwsdDecoder();
		try {
			String decoderName = "EWSD";
			Map<String, DecoderConfig> decoders = XMLDecoderConfig.load("e:\\src\\boss\\config\\decoders.xml");
			DecoderConfig config = decoders.get(decoderName);
			if (config == null) {
				throw new Exception("Can not find decoder config.");
			}
			//decoder.setStartPos(118 * 27800);
			List<Cdr> cdrs = decoder.decode(content, config);
			long t2 = (new Date()).getTime();
			int count = 0;
			for (Cdr cdr : cdrs) {
				System.out.println(cdr.getCaller() + ", " + cdr.getCallee() + ", " 
						+ sdf.format(cdr.getStartTime()) + ", " + sdf.format(cdr.getEndTime())
						//+ cdr.getBillId() + ", " + cdr.getLogId() 
						+ ", duration=" + cdr.getDuration()
						//+ "," + cdr.getLogId()
						+ ", trunkGroupIn=" + cdr.getTrunkGroupIn() + ", trunkGroupOut=" + cdr.getTrunkGroupOut());
				count++;
				if (count > 50) break;
			}
			System.out.print("size=" + cdrs.size() + ", duration=" + (t2-t1) + " ms");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
