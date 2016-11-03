package com.spring.mvc.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	@Test
	public void test() {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		assertNotNull(ctx);
	}

}
