package com.tstar.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tstar.billing.business.SidServiceBus;
import com.tstar.res.dao.ResPhoneNumberMapper;
import com.tstar.res.mapper.RefBusinessAreaMapper;
import com.tstar.res.model.RefBusinessArea;
import com.tstar.res.model.ResPhoneNumber;

public class MyBatisSessionFactory {
	private final static String resource = "config/ocs_mybatis.xml";
	private static SqlSessionFactory sessionFactory = null;
	
	static {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}
	
	public static SqlSession getSession() {
		if (sessionFactory == null) {
			synchronized (MyBatisSessionFactory.class) {
				InputStream is = MyBatisSessionFactory.class.getClassLoader().getResourceAsStream(resource);
				sessionFactory = new SqlSessionFactoryBuilder().build(is);
			}
		}
		return sessionFactory.openSession();
	}
	
	public static void main(String[] args) {
		SqlSession ss=MyBatisSessionFactory.getSession();
		ResPhoneNumberMapper resPhoneNumberMapper= ss.getMapper(com.tstar.res.dao.ResPhoneNumberMapper.class);
		ResPhoneNumber rpn = new ResPhoneNumber();
		try {
			
			rpn=resPhoneNumberMapper.findAreaByPhoneNumber("4832538");
			System.out.println(rpn.getResBillingArea().getBillingArea());
		} catch (Exception e) {
		}
		/**
		 * 获取主被叫的营业区域
		 */
		String callerBillingArea=resPhoneNumberMapper.findAreaByPhoneNumber("4832538").getResBillingArea().getBillingArea();
		String calleeBillingArea=resPhoneNumberMapper.findAreaByPhoneNumber("4832537").getResBillingArea().getBillingArea();
		/**
		 * 判断主被叫是否均为中原油田电话
		 */
		Boolean callerIsLocalPhone = !StringUtil.isEmpty(callerBillingArea);
		Boolean calleeIsLocalPhone = !StringUtil.isEmpty(calleeBillingArea);
		System.out.println(callerIsLocalPhone);
		System.out.println(calleeIsLocalPhone);
		System.out.println(callerIsLocalPhone&&calleeIsLocalPhone);
		/**
		 * 当主被叫均为中原油田电话
		 */
		if(callerIsLocalPhone&&calleeIsLocalPhone){
			/**
			 * 当主被叫在同一营业区
			 */
			if(callerBillingArea.equals(calleeBillingArea)){
				System.out.println("区内市话");
			}else { //当主被叫不在统一营业区
				System.out.println("区间市话");
			}
}
		String callName=SidServiceBus.findCallTypeName("001");
		System.out.println(callName);
	}}
