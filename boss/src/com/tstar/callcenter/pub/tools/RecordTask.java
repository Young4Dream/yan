package com.tstar.callcenter.pub.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.tstar.callcenter.dao.admin.AdminConfMapper;
import com.tstar.callcenter.pub.data.ResultMap;

public class RecordTask extends TimerTask {

	@Resource
	private AdminConfMapper adminConfMapper;

	private static final Logger logger = Logger.getLogger(RecordTask.class);

	private static final String filePath = "/var/log/orkaudio/audio/";
	private static final String newFilePath = "/var/log/orkaudio/audiodownload/";

	public void run() {
		// TODO Auto-generated method stub

		File files = new File(filePath);
		File[] filesList = files.listFiles();
		int length = filesList.length;
		if(length>0){
			logger.info("-------------------------录音文件目录开始循环-------------------------");
			logger.info("该目录下对象个数：" + length);
			for (int i = 0; i < length; i++) {
				if (filesList[i].isFile()) {

					String fileName = filesList[i].getName();

					int res = saveRecord(fileName); // 存数据库

					if(res>0){
						/** 移动文件 **/
						copyFile(filePath + fileName, newFilePath + fileName);// 复制文件
						delFile(filePath + fileName);// 删除文件
						/** ******* **/
					}
					
				}
			}
			logger.info("-------------------------录音文件目录结束循环-------------------------");
			logger.info("");
		}
		
	}

	/**
	 * 分解文件名，存入数据表
	 * 
	 * @param fileName
	 *            String 格式如：//2016-03-24-16-03-59_1002_1002_8193.mp3
	 *            2016-03-24-16-03-59_1002_8193.mp3
	 * @return int
	 */
	private int saveRecord(String fileName) {
		int res  = 0;
		try{
			String[] s = fileName.split("_");
			String time = s[0];
			String userTel = s[1];
			String customerTel = (s[2].split("\\."))[0];

			String[] timeTemp = time.split("-");
			time = timeTemp[0] + "-" + timeTemp[1] + "-" + timeTemp[2] + " "
					+ timeTemp[3] + ":" + timeTemp[4] + ":" + timeTemp[5];
			
			//Map<String, String[]> map = ParamUtil.USER_NO_TEL_MAP;
			
			ResultMap rmap = new ResultMap();
			rmap.put("phone", userTel);
			rmap.put("time", time);
			List<ResultMap> ss = adminConfMapper.selectEmplByLog(rmap);
			String emplNo = ss.get(0).getAttribute("empl_no");
			String emplName = ss.get(0).getAttribute("empl_name");
			
			logger.info("文件名：" + fileName + "  时间：" + time + "  坐席号："
					+ emplNo +"  坐席姓名："+emplName+ "  坐席电话：" + userTel + "  客户电话："
					+ customerTel);
			
			Date dateTime = new Date();
			try {
				dateTime = DateUtil.parse(time, "yyyy-MM-dd HH:mm:ss");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			ResultMap para = new ResultMap();
			para.put("file_path", newFilePath+fileName);
			para.put("creat_time", dateTime);
			para.put("empl_no", emplNo);
			para.put("empl_name", emplName);
			para.put("user_tel", userTel);
			para.put("customer_tel", customerTel);
			
			res= adminConfMapper.insertRecord(para);
		}catch(Exception e){
			e.getMessage();
		}
		
		
		return res;
	}

	/**
	 * 复制单个文件
	 * 
	 * @param oldPath
	 *            String 原文件路径 如：/xx/test.txt
	 * @param newPath
	 *            String 复制后路径 如：/xxx/test.txt
	 * @return
	 */
	private void copyFile(String oldPath, String newPath) {
		try {
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { // 文件存在时
				FileInputStream inStream = new FileInputStream(oldPath); // 读入原文件
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param filePathAndName
	 *            String 文件路径及名称 如/test.txt
	 * @param fileContent
	 *            String
	 * @return boolean
	 */
	public void delFile(String filePathAndName) {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			java.io.File myDelFile = new java.io.File(filePath);
			myDelFile.delete();
		} catch (Exception e) {
			System.out.println("删除文件操作出错");
			e.printStackTrace();
		}

	}

}
