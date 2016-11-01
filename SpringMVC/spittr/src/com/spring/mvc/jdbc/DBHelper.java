package com.spring.mvc.jdbc;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class DBHelper{
	public static ApplicationContext ctx=null;
	public static DataSource ds=null;
	public static JdbcTemplate jt=null;
	public static NamedParameterJdbcTemplate npjt=null;
	{
		try {
			ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
			ds=(DataSource) ctx.getBean(javax.activation.DataSource.class);
			ds.getConnection();
			jt=(JdbcTemplate) ctx.getBean("jdbcTemplate");
			npjt=(NamedParameterJdbcTemplate) ctx.getBean(NamedParameterJdbcTemplate.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
