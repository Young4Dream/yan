package com.tstar.util;

import org.apache.ibatis.session.SqlSession;
import com.tstar.res.dao.ResPhoneNumberMapper;
import com.tstar.res.model.ResPhoneNumber;

public class Test {
public static void main(String[] args) {
	SqlSession sqlSession= null;
	try {
		sqlSession = SqlSessionFactoryUtil.openSqlSession();
		ResPhoneNumberMapper m= sqlSession.getMapper(com.tstar.res.dao.ResPhoneNumberMapper.class);
		ResPhoneNumber rpn = new ResPhoneNumber();
		rpn=m.findAreaByPhoneNumber("4472002");
		System.out.println("begin");
		System.out.println(rpn.getResBillingArea().getBillingArea());
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
