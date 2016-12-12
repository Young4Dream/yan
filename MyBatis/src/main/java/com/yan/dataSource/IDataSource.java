package com.yan.dataSource;

import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

public class IDataSource extends BasicDataSource implements DataSourceFactory{
	private Properties p=null;
	@Override
	public DataSource getDataSource() {
		DataSource dataSource=null;
		try{
			System.out.println("使用自定义数据源（DBCP）实现连接成功~");
			dataSource=BasicDataSourceFactory.createDataSource(p);
		}catch(Exception e){
			e.printStackTrace();
		}
		return dataSource;
	}
	@Override
	public void setProperties(Properties arg0) {
		this.p=arg0;
	}

}
