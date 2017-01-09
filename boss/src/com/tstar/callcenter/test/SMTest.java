package com.tstar.callcenter.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tstar.portal.service.SysSequenceService;

public class SMTest {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SysSequenceService service = (SysSequenceService)ctx.getBean("sysSequenceServiceImpl");
		System.out.println(service.currVal("CUSTOMER_NO"));
		System.out.println(service.currVal("JOB_NO", new Date()));
	}
}
