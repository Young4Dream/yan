package com.tstar.callcenter.pub.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties相关操作
 * 
 * @author lxm
 * @version 0.1 2015-3-6 15:05:32
 */
public class PropertiesUtil {

	/**
	 * 增加属性文件值
	 * @param key
	 * @param value
	 * @param file
	 */
	public static void addProperties(String key, String value, String file) {
		Properties iniFile = getProperties(file);
		FileOutputStream oFile = null;
		try {
			iniFile.put(key, value);
			oFile = new FileOutputStream(file, true);
			iniFile.store(oFile, "add properties file");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oFile != null) {
					oFile.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读取配置文件
	 * @param file
	 * @return
	 */
	public static Properties getProperties(String file) {
		Properties pro = null;
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			pro = new Properties();
			pro.load(in);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return pro;
	}

	/**
	 * 保存属性到文件中
	 * @param pro
	 * @param file
	 */
	public static void saveProperties(Properties pro, String file) {
		if (pro == null) {
			return;
		}
		FileOutputStream oFile = null;
		try {
			oFile = new FileOutputStream(file, false);
			pro.store(oFile, "modify properties file");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oFile != null) {
					oFile.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 修改属性文件
	 * @param key 
	 * @param value
	 * @param file
	 * @return
	 */
	public static void updateProperties(String key, String value, String file) {
		if (key == null || "".equalsIgnoreCase(key)) {
			return;
		}
		Properties pro = getProperties(file);
		if (pro == null) {
			pro = new Properties();
		}
		pro.put(key, value);

		// 保存属性到文件中
		saveProperties(pro, file);
	}
	public static void main(String[] args) {
		System.out.println(getProperties("E:/work/db.properties").get("aaaa"));
	}
}
