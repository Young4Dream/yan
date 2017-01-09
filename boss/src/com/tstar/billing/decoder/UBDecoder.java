package com.tstar.billing.decoder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.tstar.ocs.model.Cdr;
import com.tstar.util.FileHelper;
import com.tstar.util.Log;

public class UBDecoder implements IDecoder{
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
	private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static Logger log=Log.getLogger();
	String path;
	public  List<Cdr> decode(String filePath, DecoderConfig config) throws Exception {
		byte[] content = FileHelper.copyFile(filePath);
		if (content == null) return null;
		this.path=filePath;
		return decode(content, config);
	}

	public static void main(String[] args) throws Exception {
		long t1 = (new Date()).getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//byte[] content = FileHelper.copyFile("C:\\Users\\yan\\Desktop\\中原油田项目\\中原-话单\\中心站华为\\UB20161211.UB");
		//System.out.println("fileSize=" + content.length);
		IDecoder decoder = new UBDecoder();
		try {
			String decoderName = "UB";
			Map<String, DecoderConfig> decoders = XMLDecoderConfig.load("config/decoders.xml");
			DecoderConfig config = decoders.get(decoderName);
			if (config == null) {
				throw new Exception("Can not find decoder config.");
			}
			log.debug(config.toString());
			log.info(config.toString());
			log.warn(config.toString());
			//decoder.setStartPos(118 * 27800);
			List<Cdr> cdrs = decoder.decode("C:\\Users\\yan\\Desktop\\中原油田项目\\中原-话单\\中心站华为\\UB12131804.UB", config);
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
//		long l2=System.currentTimeMillis();
//		System.out.println(l2-l1);
	}
	@Override
	public List<Cdr> decode(byte[] content, DecoderConfig config) throws Exception {
		List<Cdr> cdrs=new ArrayList<Cdr>();
		File file = new File(this.path); 
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
		String tempString = null;
        while ((tempString = reader.readLine()) != null) { 
        	Cdr cdr=new Cdr();
            String[] ss=tempString.split(",");
            for(int i=0;i<ss.length;i=i+7){
            	String start=sdf.parse(ss[i+4].trim()).toLocaleString();
            	String end =sdf.parse(ss[i+5].trim()).toLocaleString();
            	Date startTime=df.parse(start);
            	Date endTime=df.parse(end);
            	cdr.setCaller(ss[i].trim());
            	cdr.setCallee(ss[i+1].trim());
            	cdr.setStartTime(startTime);
            	cdr.setEndTime(endTime);
            	cdr.setTrunkGroupIn(ss[i+2]);
            	cdr.setDuration(Integer.parseInt(ss[i+6].trim()));
            }
			/**
			 * intercepter : add normal cdr where length of caller less than 11
			 * date : 2017.01.03
			 */
			if(cdr.getCaller().length()<=11){
				cdrs.add(cdr);
			}
        }
        for(Cdr cdr:cdrs){
        	System.out.println(cdr.toString());
        }
		return cdrs;
	}
@Override
public void setStartPos(int pos) {
	// TODO Auto-generated method stub
}

}
