package com.tstar.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	private static final SimpleDateFormat sdfMedium = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
	private static final SimpleDateFormat sdfLong = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
	private static final SimpleDateFormat sdfShort = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String format(Date dt) {
		return sdfMedium.format(dt);
	}
	
	public static String formatDate(Date dt) {
		return sdfShort.format(dt);
	}
	
	public static String formatTime(Date dt) {
		return sdfTime.format(dt);
	}
	
	public static String formatWhole(Date dt) {
		return sdfLong.format(dt);
	}
	
	public static Date parse(String str) throws Exception {
		return sdfMedium.parse(str);
	}
	
	public static Date parse1(String str) throws Exception {
		String pattern = "";
		int len = str.length();
		if (len == 10) {
			pattern = str + " 00:00:00";
		} else if (len == 16) {
			pattern = str + ":00";
		}
		return sdfMedium.parse(pattern);
	}
	
	public static int getDay(Date dt) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public static Date getDayBegin(Date dt) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	public static Date getDayEnd(Date dt) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}
	
	public static Date addMonth(Date dt, int count) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(dt);
		gc.add(GregorianCalendar.MONTH, count);
		return gc.getTime();
	}
	
	public static Date add(Date dt, String term, int count) {
		String t = term.toUpperCase();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(dt);
		if ("DAY".equals(t)) {
			gc.add(GregorianCalendar.DAY_OF_MONTH, count);
		} else if ("WEEK".equals(t)) {
			gc.add(GregorianCalendar.DAY_OF_MONTH, 7 * count);
		} else if ("MONTH".equals(t)) {
			gc.add(GregorianCalendar.MONTH, count);
		} else if ("SEASON".equals(t)) {
			gc.add(GregorianCalendar.MONTH, 3 * count);
		} else if ("HALFOFYEAR".equals(t)) {
			gc.add(GregorianCalendar.MONTH, 6 * count);
		} else if ("YEAR".equals(t)) {
			gc.add(GregorianCalendar.YEAR, count);
		}
		gc.add(GregorianCalendar.MILLISECOND, -1);
		return gc.getTime();
	}
	
	public static Date[] getBillingTerm(Date dt, int billingDay) {
		Date[] ds = new Date[2];
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		if (billingDay == 0) {
			// 账期从当前日开始
			ds[0] = calendar.getTime();
		} else {
			int currDay = calendar.get(Calendar.DAY_OF_MONTH);
			if (currDay > billingDay) {
				// 当前日在账期日之后，账期从本月账期日开始
				calendar.set(Calendar.DAY_OF_MONTH, billingDay);
				ds[0] = calendar.getTime();
			} else {
				// 当前日在账期日之前，则属于上个月账期
				calendar.add(Calendar.MONTH, -1);
				calendar.set(Calendar.DAY_OF_MONTH, billingDay);
				ds[0] = calendar.getTime();
			}
		}
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.MILLISECOND, -1);
		ds[1] = calendar.getTime();
		return ds;
	}
	
	public static Date[] getBillingTerm(Date dt, String term, int termCount, int billingDay) {
		Date[] ds = new Date[2];
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		if (billingDay == 0) {
			// 账期从当前日开始
			ds[0] = calendar.getTime();
			ds[1] = add(ds[0], term, termCount);
		} else {
			// 固定账期日
			int currDay = calendar.get(Calendar.DAY_OF_MONTH);
			if (currDay > billingDay) {
				// 当前日在账期日之后，账期从本月账期日开始
				calendar.set(Calendar.DAY_OF_MONTH, billingDay);
				ds[0] = calendar.getTime();
			} else {
				// 当前日在账期日之前，则属于上个月账期
				calendar.add(Calendar.MONTH, -1);
				calendar.set(Calendar.DAY_OF_MONTH, billingDay);
				ds[0] = calendar.getTime();
			}
			int monthCount = 1;
			if ("SEASON".equals(term)) {
				monthCount = 3;
			} else if ("HALFOFYEAR".equals(term)) {
				monthCount = 6;
			} else if ("YEAR".equals(term)) {
				monthCount = 12;
			}
			calendar.add(Calendar.MONTH, monthCount * termCount);
			calendar.add(Calendar.MILLISECOND, -1);
			ds[1] = calendar.getTime();
		}
		return ds;
	}
	
	public static boolean isFirstMonth(String term, int billingDay, Date startDt, Date dt) {
		Date[] ds = getBillingTerm(startDt, billingDay);
		if (dt.getTime() > ds[1].getTime()) {
			return false;
		} else {
			return true;
		}
	}
	
	public static int getTermDays(String t) {
		if ("DAY".equals(t)) {
			return 1;
		} else if ("WEEK".equals(t)) {
			return 7;
		} else if ("MONTH".equals(t)) {
			return 30;
		} else if ("SEASON".equals(t)) {
			return 90;
		} else if ("HALFOFYEAR".equals(t)) {
			return 180;
		} else if ("YEAR".equals(t)) {
			return 360;
		} else {
			return 1;
		}
	}
	
	public static Date endOfWorld() {
		Date dt = new Date();
		try { dt = sdfLong.parse("2999-12-31 00:00:00 000"); } catch(Exception e) {};
		return dt;
	}
	
	public static void main(String[] args) throws Exception {
		Date now = new Date();
		System.out.println("current time: " + sdfLong.format(now));
		Date dt1 = add(now, "day", 4);
		Date dt2 = add(now, "week", 1);
		Date dt3 = add(now, "month", 1);
		Date dt4 = add(now, "season", 1);
		Date dt5 = add(now, "year", 1);
		System.out.println("start date: " + sdfLong.format(dt1));
		System.out.println("start date: " + sdfLong.format(dt2));
		System.out.println("start date: " + sdfLong.format(dt3));
		System.out.println("start date: " + sdfLong.format(dt4));
		System.out.println("start date: " + sdfLong.format(dt5));
		String s = "2016-12-10 01:02:03";
		System.out.println("" + sdfMedium.parse(s));
		Date[] ds = getBillingTerm(now, 1);
		System.out.println("start date: " + sdfLong.format(ds[0]));
		System.out.println("end date:" + sdfLong.format(ds[1]));
	}
}
