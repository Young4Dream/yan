package com.tstar.billing.business;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tstar.ocs.dao.CdrMapper;
import com.tstar.ocs.model.Cdr;
import com.tstar.util.MyBatisSessionFactory;
import com.tstar.util.UUID;

public class CdrBus {
	
	public static List<Cdr> getSortingCdrs(String logId, int status) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			CdrMapper dao = session.getMapper(CdrMapper.class);
			return dao.selectPricingByLogId(logId, status);
		} finally {
			session.close();
		}
	}
	
	public static void insert(List<Cdr> cdrs) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			CdrMapper dao = session.getMapper(CdrMapper.class);
			for (Cdr cdr : cdrs) {
				cdr.setId(UUID.get());
				cdr.setCreateTime(new Date());
				dao.insert(cdr);
			}
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public static void update(List<Cdr> cdrs) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			CdrMapper dao = session.getMapper(CdrMapper.class);
			for (Cdr cdr : cdrs) {
				cdr.setUpdateTime(new Date());
				dao.updateByPrimaryKey(cdr);
			}
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public static void clearSortingCdrs(String logId) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			CdrMapper dao = session.getMapper(CdrMapper.class);
			dao.deleteByLogId(logId);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public static void deleteByPrimaryKey(String id) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			CdrMapper dao = session.getMapper(CdrMapper.class);
			dao.deleteByPrimaryKey(id);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public static Cdr getDuplicatedCdr(Cdr cdr) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			CdrMapper dao = session.getMapper(CdrMapper.class);
			List<Cdr> lst = dao.selectByHashCode(cdr.getId(), cdr.hashCode());
			if (lst == null || lst.size() == 0) return null;
			for (Cdr obj : lst) {
				if (cdr.equals(obj)) {
					/*
					System.out.println(cdr.getId() + ", " + obj.getId());
					System.out.println(cdr.getCaller() + ", " + obj.getCaller());
					System.out.println(cdr.getCallee() + ", " + obj.getCallee());
					System.out.println("" + cdr.getStartTime() + ", " + obj.getStartTime());
					System.out.println("" + cdr.getDuration() + ", " + obj.getDuration());
					*/
					return obj;
				}
			}
			return null;
		} finally {
			session.close();
		}
	}
	
}
