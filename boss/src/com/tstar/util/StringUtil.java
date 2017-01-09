package com.tstar.util;

public class StringUtil {

	public static boolean isEmpty(String s) {
		return (s == null || "".equals(s));
	}
	
	public static String join(String[] arr, String connector) {
		String res = "";
		for (int i = 0; i < arr.length; i++) {
			if (isEmpty(arr[i])) {
				continue;
			}
			if (res.length() == 0) {
				res += connector;
			}
			res += arr[i];
		}
		return res;
	}
	
	public static String join(String ch, int len) {
		if (len <= 0) return "";
		String res = ch;
		for (int i = 1; i < len; i++) {
			res += ch;
		}
		return res;
	}
	
	public static String getSplitter(String str) {
		int len = str.length();
		for (int i = 0; i < len; i++) {
			String ch = str.substring(i, i + 1);
			if ("#".equals(ch) || "-".equals(ch) || "/".equals(ch)) {
				return ch;
			}
		}
		return "-";
	}
	
	public static void main(String[] args) throws Exception {
		String s = "0001";
		System.out.println(s.substring(0, 0));
		System.out.println(s.substring(0, 4));
		String[] infos = s.split("-");
		System.out.println(infos.length);
		//System.out.println(infos[0]);
		for (int i = 0; i < infos.length; i++) {
			System.out.println(infos[i]);
		}
		s = "00-0-00";
		System.out.println(getSplitter(s));
	}
}
