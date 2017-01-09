package com.tstar.callcenter.pub.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期相关操作
 * 
 * @author lxm
 * @version 0.1 2015-3-6 15:45:58
 */
public class DateUtil {
	/** 存储所有日期格式类 */
	@SuppressWarnings("unchecked")
	private static final Map mapFormat = new HashMap();

	/**
	 * 得到中文的日期格式字符串 具体格式：yyyy年MM月dd日 HH点mm分ss秒.
	 * 
	 * @param date
	 * @return 中文的日期字符串
	 */
	public static String formatZh(Date date) {
		return format(date, "yyyy年MM月dd日 hh点mm分ss秒");
	}

	/**
	 * 得到紧凑的日期格式字符串 具体格式：yyyy年MM月dd日 HH:mm:ss.
	 * 
	 * @param date
	 * @return 中文的日期字符串
	 */
	public static String formatCompact(Date date) {
		return format(date, "yyyyMMdd hh:mm:ss");
	}

	/**
	 * 得到默认日期格式字符串 具体格式：yyyy-MM-dd HH:mm:ss.
	 * 
	 * @param date
	 * @return 默认格式字符串
	 */
	public static String format(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 返回特定格式的日期表达形式.
	 * 
	 * @param date
	 * @param pattern
	 *            日期格式字符串
	 * @return 表示日期的字符串
	 */
	public static String format(Date date, String pattern) {
		return getDateFormat(pattern).format(date);
	}

	/**
	 * 解析日期字符串
	 * 
	 * @param strDate
	 *            要解析的字符串
	 * @param pattern
	 *            解析格式
	 * @return 解析出的日期
	 * @throws ParseException
	 */
	public static Date parse(String strDate, String pattern) throws ParseException {
		return getDateFormat(pattern).parse(strDate);
	}

	/**
	 * 得到指定的日期格式化类
	 * 
	 * @param key
	 *            指定格式
	 * @return 所指定的日期格式化类
	 */
	private static DateFormat getDateFormat(String key) {
		DateFormat format = (DateFormat) mapFormat.get(key);
		if (format == null) {
			format = new SimpleDateFormat(key);
		}
		return format;
	}

	 public static void main(String[] args) throws Exception {
		 	System.out.println(format(new Date(),"yyyy-MM-DD HH:mm:ss"));
		 	
	 }
}
