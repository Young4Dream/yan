package com.spring.mvc.jdbc;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBHelper{
	public static ApplicationContext ctx=null;
	public static DataSource ds=null;
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		ds=(DataSource) ctx.getBean(javax.activation.DataSource.class);
	}
}
