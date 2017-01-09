package com.tstar.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
}
