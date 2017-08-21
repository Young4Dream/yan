package com.tstar.util;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory=null;
    private static final Class<SqlSessionFactoryUtil> CLASS_LOCK=SqlSessionFactoryUtil.class;
    /**
     * 私有化构造参数
     */
    private SqlSessionFactoryUtil(){};

    public static SqlSessionFactory initSqlSessionFactory(){
        String resource="sqlMapConfig.xml";
        InputStream is=null;
        try{
            is=Resources.getResourceAsStream(resource);
        }catch(Exception e){
            Logger.getLogger(SqlSessionFactoryUtil.class.getName()).log(Level.SEVERE, null,e);
        }
        synchronized (CLASS_LOCK) {
            if(sqlSessionFactory==null){
                sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
            }
        }
        return sqlSessionFactory;
    }
    public static SqlSession openSqlSession() {
        if(sqlSessionFactory==null){
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}