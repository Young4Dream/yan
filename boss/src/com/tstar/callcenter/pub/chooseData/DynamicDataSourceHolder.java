package com.tstar.callcenter.pub.chooseData;

public class DynamicDataSourceHolder {
	public static final ThreadLocal<String> holder = new ThreadLocal<String>();
	
	public static void putDateSource(String name){
		holder.set(name);
	}
	
	public static String getDateSource(){
		return holder.get();
		
	}
}
