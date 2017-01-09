package com.tstar.billing.business;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.ibatis.session.SqlSession;

import com.tstar.ocs.dao.SidOperatorRateMapper;
import com.tstar.ocs.dao.SidRateMapper;
import com.tstar.ocs.model.SidOperatorRate;
import com.tstar.ocs.model.SidRate;
import com.tstar.util.MyBatisSessionFactory;

public class SidRateBus {
	
	/**
	 * 获取兜底费率
	 */
	private static Map<String, SidRate> defaultRates = null;  // SERVICE_ID作为主键
	private static Map<String, SidRate> cacheRates = null; // RATE_ID作为主键
	public static SidRate findDefaultRate(String serviceId) {
		if (defaultRates == null) {
			loadDefaultRates();
		}
		if (defaultRates != null) {
			return defaultRates.get(serviceId);
		} else {
			return null;
		}
	}
	
	public static SidRate findRateById(String rateId) {
		if (cacheRates == null) {
			loadDefaultRates();
		}
		if (cacheRates == null) {
			return null;
		} else {
			return cacheRates.get(rateId);
		}
	}
	
	private static void loadDefaultRates() {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			SidRateMapper dao = session.getMapper(SidRateMapper.class);
			List<SidRate> lst = dao.selectDefaultRates();
			if (lst == null || lst.size() == 0) return;
			defaultRates = new ConcurrentHashMap<String, SidRate>();
			cacheRates = new ConcurrentHashMap<String, SidRate>();
			for (SidRate obj : lst) {
				defaultRates.put(obj.getServiceId(), obj);
				cacheRates.put(obj.getId(), obj);
			}
		} finally {
			session.close();
		}
	}
	
	/**
	 * 运营商网间结算费率
	 */
	private static Map<String, SidRate> opRates = null;
	public static SidRate findOpRate(String opId, String serviceId) {
		if (opRates == null) {
			SqlSession session = MyBatisSessionFactory.getSession();
			try {
				SidOperatorRateMapper dao = session.getMapper(SidOperatorRateMapper.class);
				SidRateMapper daoRate = session.getMapper(SidRateMapper.class);
				List<SidOperatorRate> lst = dao.selectAll();
				opRates = new ConcurrentHashMap<String, SidRate>();
				for (SidOperatorRate obj : lst) {
					String key = obj.getOpId() + "-" + obj.getServiceId();
					//System.out.println("rateId=" + obj.getRateId());
					SidRate rate = daoRate.selectByPrimaryKey(obj.getRateId());
					//System.out.println("rateName=" + (rate == null ? "null" : rate.getName()));
					opRates.put(key, rate);
				}
			} finally {
				session.close();
			}
		}
		String key = opId + "-" + serviceId;
		return opRates.get(key);
	}
	
	public static void main(String[] args) {
		SidRate rate = findDefaultRate("001");
		System.out.println(rate.getName());
	}
	
}
