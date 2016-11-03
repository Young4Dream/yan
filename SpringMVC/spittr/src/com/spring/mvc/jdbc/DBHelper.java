package com.spring.mvc.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
public class DBHelper implements ApplicationContextAware{
	
	public static ApplicationContext ctx;
	public static DataSource ds;
	public static JdbcTemplate jt;
	public static NamedParameterJdbcTemplate npjt;
	{
		DBHelper.ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		jt=(JdbcTemplate) ctx.getBean("jdbcTemplate");
		npjt=(NamedParameterJdbcTemplate) ctx.getBean(NamedParameterJdbcTemplate.class);
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		ctx=arg0;
	}
	public DBHelper(){
	}
	/**
	 * 根据ctx对象获取连接
	 */
	public static synchronized Connection getConnection(){
		try {
			ComboPooledDataSource cds=(ComboPooledDataSource) ctx.getBean("dataSourceLocal");
			return cds.getConnection();
		} catch (SQLException e) {
			return null;
		}
	}
}
