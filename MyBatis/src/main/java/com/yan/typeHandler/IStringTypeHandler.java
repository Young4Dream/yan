package com.yan.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
//@MappedTypes(String.class)
//@MappedJdbcTypes(JdbcType.VARCHAR)
public class IStringTypeHandler implements  TypeHandler<String>{

	private static final Logger log=Logger.getLogger(IStringTypeHandler.class.getName());
//	@Override
//	public String getNullableResult(ResultSet arg0, String arg1)
//			throws SQLException {
//		log.info("自定义StringTypeHandler，ResultSet根据列名"+arg1);
//		return arg0.getString(arg1);
//	}
//
//	@Override
//	public String getNullableResult(ResultSet arg0, int arg1)
//			throws SQLException {
//		log.info("自定义StringTypeHandler，ResultSet根据下标"+arg1);
//		return arg0.getString(arg1);
//	}
//
//	@Override
//	public String getNullableResult(CallableStatement arg0, int arg1)
//			throws SQLException {
//		log.info("自定义StringTypeHandler，CallableStatement存储过程"+arg0);
//		return arg0.getString(arg1);
//	}
//
//	@Override
//	public void setNonNullParameter(PreparedStatement arg0, int arg1,
//			String arg2, JdbcType arg3) throws SQLException {
//		log.info("自定义StringTypeHandler");
//		
//	}

	@Override
	public String getResult(ResultSet arg0, String arg1) throws SQLException {
		log.info("自定义StringTypeHandler，ResultSet根据列名"+arg1);
		return arg0.getString(arg1);
	}

	@Override
	public String getResult(ResultSet arg0, int arg1) throws SQLException {
		log.info("自定义StringTypeHandler，ResultSet根据下标"+arg1);
		return arg0.getString(arg1);
	}

	@Override
	public String getResult(CallableStatement arg0, int arg1)
			throws SQLException {
		log.info("自定义StringTypeHandler，CallableStatement存储过程"+arg0);
		return arg0.getString(arg1);
	}

	@Override
	public void setParameter(PreparedStatement arg0, int arg1, String arg2,
			JdbcType arg3) throws SQLException {
		log.info("自定义StringTypeHandler");
		arg0.setString(arg1, arg2);
	}

}
