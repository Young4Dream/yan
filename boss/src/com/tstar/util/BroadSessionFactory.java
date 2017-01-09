/**
 * 
 */
package com.tstar.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author zhumengfeng
 *
 */
public class BroadSessionFactory {
	private final static String resource = "config/broadMapConfig.xml";
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
