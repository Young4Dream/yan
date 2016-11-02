package com.spring.mvc.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBHelper implements ApplicationContextAware{
	public static ApplicationContext ctx=null;
	public static DataSource ds=null;
	public static JdbcTemplate jt=null;
	public static NamedParameterJdbcTemplate npjt=null;
	/**
	 * 在Spring启动时自动获得Spring 的 ApplicationContext
	 */
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		DBHelper.ctx=arg0;
		jt=(JdbcTemplate) ctx.getBean("jdbcTemplate");
		npjt=(NamedParameterJdbcTemplate) ctx.getBean(NamedParameterJdbcTemplate.class);
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
}
