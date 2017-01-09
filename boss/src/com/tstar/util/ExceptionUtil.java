/**
 * 
 */
package com.tstar.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author zhumengfeng
 *
 */
public class ExceptionUtil {
	
	public static String getStackTrace(Exception e) {
		String val = null;
		StringWriter sw = null;
		PrintWriter pw = null;
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			pw.flush();
			sw.flush();
			val = sw.toString();
		} finally {
			if (pw != null) {
				pw.close();
			}
			if (sw != null) {
				try { sw.close(); } catch (Exception e1) {}
			}
		}
		return val;
	}
	
	public static void main(String args[]) {
		try {
			throw new Exception("Hello");
		} catch (Exception e) {
			System.out.println(getStackTrace(e));
		}
	}
}
