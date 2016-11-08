package com.spring.mvc.test;

import static org.junit.Assert.*;

import org.junit.Test;
import com.spring.mvc.jdbc.DBHelper;

public class Demo {
	@Test
	public void test() {
//		ApplicationContext ctx =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		assertNotNull(DBHelper.getCtx());
		assertNotNull(DBHelper.getConnection());
		assertNotNull(DBHelper.getLog());
	}
}
