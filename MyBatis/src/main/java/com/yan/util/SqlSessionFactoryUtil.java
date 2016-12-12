package com.yan.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yan.dec.DesUtils;


public class SqlSessionFactoryUtil {
	
	private static SqlSessionFactory sqlSessionFactory=null;
	private static final Class<SqlSessionFactoryUtil> CLASS_LOCK=SqlSessionFactoryUtil.class;
	/**
	 * 私有化构造参数
	 */
	private SqlSessionFactoryUtil(){};
	
	public static SqlSessionFactory initSqlSessionFactory(){
		String xmlResource="mybatis-config.xml";
		String jdbcProperty="jdbc.properties";
		InputStream cfgStream=null;
		Reader cfgReader=null;
		InputStream proStream=null;
		Reader proReader=null;
		Properties p=null;
		try {
			//读入配置文件流
			cfgStream=Resources.getResourceAsStream(xmlResource);
			cfgReader=new InputStreamReader(cfgStream);
			//读入属性文件
			proStream=Resources.getResourceAsStream(jdbcProperty);
			proReader=new InputStreamReader(proStream);
			p=new Properties();
			p.load(proReader);
			//解密
			String encUsername=p.getProperty("username");
			String encPassword=p.getProperty("password");
			DesUtils des;
			try {
				des = new DesUtils("tsd");
				String decUsername=des.decrypt(encUsername);
						String decPassword=des.decrypt(encPassword);
//						System.out.println(decUsername+decPassword);
				p.setProperty("username", decUsername);
				p.setProperty("password", decPassword);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			Logger.getLogger(SqlSessionFactoryUtil.class.getName()).log(Level.SEVERE, null,e);
		}
		synchronized (CLASS_LOCK) {
			if(sqlSessionFactory==null){
				sqlSessionFactory=new SqlSessionFactoryBuilder().build(cfgReader,p);
			}
		}
		return sqlSessionFactory;
	}
	public static SqlSession openSqlSession() {
		if(sqlSessionFactory==null){
			initSqlSessionFactory();
		}
		System.out.println("使用的数据库为："+sqlSessionFactory.getConfiguration().getDatabaseId());
		return sqlSessionFactory.openSession();
	}
}
