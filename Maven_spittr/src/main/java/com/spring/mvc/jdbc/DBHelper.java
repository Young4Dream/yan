package com.spring.mvc.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import com.mchange.v2.c3p0.ComboPooledDataSource;
public class DBHelper{
	
	public static Logger log;
	public static ApplicationContext ctx;
	{
		log=Logger.getLogger(DBHelper.class);
	}
	public DBHelper(){
	}
	/**
	 * 根据ctx对象获取连接
	 */
	public static synchronized Connection getConnection(){
		try {
			ComboPooledDataSource cds=(ComboPooledDataSource) ctx.getBean("dataSource");
			return cds.getConnection();
		} catch (SQLException e) {
			return null;
		}
	}
	public static Logger getLog() {
		return log;
	}
	public static void setLog(Logger log) {
		DBHelper.log = log;
	}
	public static ApplicationContext getCtx() {
		return ctx;
	}
	public static void setCtx(ApplicationContext ctx) {
		DBHelper.ctx = ctx;
	}
}
