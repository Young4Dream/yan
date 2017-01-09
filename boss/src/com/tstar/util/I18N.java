/**
 * 
 */
package com.tstar.util;

import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author zhumengfeng
 *
 */
public class I18N {
	
	public static Properties dict = null;
	
	public static String translate(String word) {
		if (dict == null) {
			//Resource resource = new ClassPathResource("/config/i18n.properties");
			//try { dict = PropertiesLoaderUtils.loadProperties(resource); } catch (Exception e) {}
			dict = new Properties();
			try { 
				dict.load(new InputStreamReader(I18N.class.getClassLoader().getResourceAsStream("config/i18n.properties"), "UTF-8"));
			} catch (Exception e) {
				System.out.println(ExceptionUtil.getStackTrace(e));
			}
		}
		String res = dict.getProperty(word);
		if (res == null) {
			return word;
		} else {
			return res;
		}
	}
	
	public static void main(String[] args) throws Exception {
		//System.out.println(translate("PortRoute_"));
		//System.out.println(translate("Site_"));
		//System.out.println("abc".indexOf("d"));
		String a = "孩子";
		byte[] bs = a.getBytes("utf-8");
		String aa = new String(bs);
		System.out.println(aa);
	}
}
