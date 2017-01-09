package com.tstar.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ByteHelper {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// Convert big endian bytes to integer
	public static int Bytes2Int(byte[] vals, int pos, int len) {
		assert(len<=4);
		int val = 0;
		for (int i = 0; i < len; i++) {
			val += (vals[pos + i] & 0xff) << 8 * (len - i - 1);
		}
		return val;
	}
	
	// Convert little endian bytes to integer
	public static int LEBytes2Int(byte[] vals, int pos, int len) {
		assert(len<=4);
		int val = 0;
		byte[] tmp = new byte[len];
		for (int i = 0; i < len; i++) {
			tmp[i] = vals[pos + len - i - 1];
		}
		for (int i = 0; i < len; i++) {
			val += (tmp[i] & 0xff) << 8 * (len - i - 1);
		}
		return val;
	}
	
	public static long Bytes2Long(byte[] vals, int pos, int len) {
		assert(len<=8);
		long val = 0;
		for (int i = 0; i < len; i++) {
			val += (vals[pos + i] & 0xff) << 8 * (len - i - 1);
		}
		return val;
	}
	
	public static String Bytes2String(byte[] vals, int pos, int len) {
		StringBuilder sb = new StringBuilder();
		for (int i = pos; i < pos + len; i++) {
			sb.append((char)vals[i]);
		}
		return sb.toString();
	}
	
	public static String Bytes2HexString(byte[] vals, int pos, int len, int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = pos; i < pos + len; i++) {
			String str = Integer.toHexString(0xff & vals[i]);
			if (str.length() == 1) {
				sb.append("0").append(str);
			} else {
				sb.append(str);
			}
		}
		return sb.toString().substring(0, count);
	}
	
	public static String Byte2HexString(byte b, int len) {
		String str = Integer.toHexString(b & 0xff);
		if (str.length() < len) {
			str = "0" + str;
		}
		return str;
	}
	
	public static String Byte2String(byte b, int len) {
		String str = Integer.toString(b & 0xff);
		if (str.length() < len) {
			str = "0" + str;
		}
		return str;
	}
	
	public static Date Bytes2Date(byte[] vals, int pos, int len) throws Exception {
		String strDate = "20" + Byte2HexString(vals[pos], 2) 
		               + "-" + Byte2HexString(vals[pos+1], 2)
		               + "-" + Byte2HexString(vals[pos+2], 2)
		               + " " + Byte2HexString(vals[pos+3], 2)
		               + ":" + Byte2HexString(vals[pos+4], 2)
		               + ":" + Byte2HexString(vals[pos+5], 2);
		return sdf.parse(strDate);
	}
	
	public static Date Bcd2DateTime(byte[] vals, int pos, int len) throws Exception {
		String val = Bcd2String(vals, pos, len);
		String strDate = val.substring(0, 4)
					   + "-" + val.substring(4, 6)
					   + "-" + val.substring(6, 8)
					   + " " + val.substring(8, 10)
					   + ":" + val.substring(10, 12)
					   + ":" + val.substring(12, 14);
		return sdf.parse(strDate);
	}
	
	public static Integer Bcd2Duration(byte[] vals, int pos, int len) throws Exception {
		String val = Bcd2String(vals, pos, len);
		Integer duration = 0 
						 + 3600 * Integer.parseInt(val.substring(0, 3))
						 + 60 * Integer.parseInt(val.substring(3, 5))
						 + Integer.parseInt(val.substring(5, 7));
		return duration;
	}
	
	public static Date OctalBytes2Date(byte[] vals, int pos) throws Exception {
		String strDate = "20" + Byte2String(vals[pos], 2) 
        			   + "-" + Byte2String(vals[pos+1], 2)
        			   + "-" + Byte2String(vals[pos+2], 2)
        			   + " " + Byte2String(vals[pos+3], 2)
        			   + ":" + Byte2String(vals[pos+4], 2)
        			   + ":" + Byte2String(vals[pos+5], 2);
		return sdf.parse(strDate);
	}
	
	public static Integer OctalBytes2Duration(byte[] vals, int pos, int len) throws Exception {
		String str = Bcd2String(vals, pos, len);
		return 3600 * Integer.parseInt(str.substring(0, 3)) + 
			   60 * Integer.parseInt(str.substring(3, 2)) +
			   Integer.parseInt(str.substring(5, 2));
	}
	
	public static String Bcd2String(byte[] vals, int pos, int len) throws Exception {
		char ch;
		char[] tmp = new char[len * 2];
		for (int i = 0; i < len; i++) {
			int p = pos + i;
			ch = (char)(((vals[p] & 0xf0) >> 4) & 0x0f);
			tmp[i*2] = (char)(ch > 9 ? ' ' : ch + '0');
			ch = (char)(vals[p] & 0x0f);
			tmp[i*2 + 1] = (char)(ch > 9 ? ' ' : ch + '0');
		}
		return (new String(tmp)).trim();
	}
	
	public static Object Bytes2Object(byte[] content, int pos, int len, String dataType) throws Exception {
		Object val = null;
		if (dataType.equals("bcd")) {
			val = ByteHelper.Bcd2String(content, pos, len);
		} else if (dataType.equals("string")) {
			val = ByteHelper.Bytes2String(content, pos, len);
		} else if (dataType.equals("date")) {
			val = ByteHelper.Bytes2Date(content, pos, len);
		} else if (dataType.equals("octal-date")) {
			val = ByteHelper.OctalBytes2Date(content, pos);
		} else if (dataType.equals("le-integer")) {
			// Little endian integer
			val = ByteHelper.LEBytes2Int(content, pos, len);
		} else if (dataType.equals("integer")) {
			// Big endian integer
			val = ByteHelper.Bytes2Int(content, pos, len);
		} else if (dataType.equals("le-integer-string")) {
			val = "" + ByteHelper.LEBytes2Int(content, pos, len);
		} else if (dataType.equals("bcd-duration")) {
			val = ByteHelper.Bcd2Duration(content, pos, len);
		} else if (dataType.equals("bcd-datetime")) {
			val = ByteHelper.Bcd2DateTime(content, pos, len);
		}
		return val;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
