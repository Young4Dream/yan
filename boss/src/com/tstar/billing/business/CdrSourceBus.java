package com.tstar.billing.business;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tstar.ocs.dao.CdrSourceMapper;
import com.tstar.ocs.model.CdrSource;
import com.tstar.util.MyBatisSessionFactory;

public class CdrSourceBus {

	public static List<CdrSource> getEnabledSources() {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			CdrSourceMapper dao = session.getMapper(CdrSourceMapper.class);
			return dao.selectByStatus(CdrSource.STATUS_ENABLED);
		} finally {
			session.close();
		}
	}
	
	public static List<CdrSource> getAllSources() {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			CdrSourceMapper dao = session.getMapper(CdrSourceMapper.class);
			return dao.selectAll();
		} finally {
			session.close();
		}
	}
}
