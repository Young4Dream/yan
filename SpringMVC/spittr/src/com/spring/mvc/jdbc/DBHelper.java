package com.spring.mvc.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
public class DBHelper {
	public static ApplicationContext ctx;
	public static DataSource ds;
	public static JdbcTemplate jt;
	public static NamedParameterJdbcTemplate npjt;
	{
		DBHelper.ctx=new ClassPathXmlApplicationContext("/WEB-INF/Spring-servlet.xml");
		jt=(JdbcTemplate) ctx.getBean("jdbcTemplate");
		npjt=(NamedParameterJdbcTemplate) ctx.getBean(NamedParameterJdbcTemplate.class);
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
