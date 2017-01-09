package com.tstar.billing.business;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tstar.ocs.dao.SidDiscountMapper;
import com.tstar.ocs.model.SidDiscount;
import com.tstar.util.DateUtil;
import com.tstar.util.MyBatisSessionFactory;

public class SidDiscountBus {
	public static SidDiscount getDiscount(String rateId, Date startTime) {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			SidDiscountMapper dao = session.getMapper(SidDiscountMapper.class);
			List<SidDiscount> lst = dao.selectRateDiscountByDateTime(rateId, startTime, DateUtil.formatTime(startTime));
			if (lst == null || lst.size() == 0) return null;
			return lst.get(0);
		} finally {
			session.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		String rateId = "003";
		Date dt = DateUtil.parse("2016-08-21 06:01:01");
		SidDiscount discount = getDiscount(rateId, dt);
		System.out.println(discount.getName());
	}
}
