package com.tstar.util;


public class UUID {
	private static String oldValue = "";
	private static String newValue = "";
	
	public synchronized static String get() {
		do {
			newValue = java.util.UUID.randomUUID().toString();
		} while(newValue.equals(oldValue));
		oldValue = newValue;
		return newValue;
	}
	
	public static void main(String args[]) throws Exception {
	}
}
