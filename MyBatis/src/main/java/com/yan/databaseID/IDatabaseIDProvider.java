package com.yan.databaseID;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.DatabaseIdProvider;

public class IDatabaseIDProvider implements DatabaseIdProvider{
private Properties p=null;
	@Override
	public String getDatabaseId(DataSource arg0) throws SQLException {
		String dataName=arg0.getConnection().getMetaData().getDatabaseProductName();
		String databaseId=(String) this.p.get(dataName);
		return databaseId;
	}
	@Override
	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub
		this.p=arg0;
	}

}
