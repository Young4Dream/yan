package com.tstar.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	
	private final static String LOG_CONFIG_FILE = System.getProperty("user.dir") + System.getProperty("file.separator") + "config/log4j.properties";
	//private final static String LOG_CONFIG_FILE = "config/log4j.properties";
	
	private static Logger logger = null;
	
	public static Logger getLogger(){
		if (logger == null) {
			logger  =  Logger.getLogger(Log.class );
			PropertyConfigurator.configure( LOG_CONFIG_FILE);
		}
		return logger;
	}
	/*
	private static final boolean isTest = true;
	
	public static Logger getLogger(){
		Logger logger  =  Logger.getLogger(Log.class );
		if (isTest) {
			PropertyConfigurator.configure( "src/sysconfig/log4j.properties" ); // For test
		} else {
			PropertyConfigurator.configure( "sysconfig/log4j.properties" );
		}
		return logger;
	} */
}