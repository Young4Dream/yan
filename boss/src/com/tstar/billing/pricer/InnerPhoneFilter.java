package com.tstar.billing.pricer;

import org.apache.ibatis.session.SqlSession;

import com.tstar.billing.business.SidRateBus;
import com.tstar.ocs.model.Cdr;
import com.tstar.ocs.model.SidRate;
import com.tstar.res.dao.ResPhoneNumberMapper;
import com.tstar.util.MyBatisSessionFactory;
import com.tstar.util.StringUtil;

public class InnerPhoneFilter {

	// public static List<Cdr> filt(List<Cdr> cdrs) {
	// // TODO Auto-generated method stub
	// SqlSession ss=MyBatisSessionFactory.getSession();
	// ResPhoneNumberMapper
	// resPhoneNumberMapper=ss.getMapper(com.tstar.res.dao.ResPhoneNumberMapper.class);
	// for(Cdr cdr:cdrs){
	// try {
	// /**
	// * 获取主被叫的营业区域
	// */
	// String
	// callerBillingArea=resPhoneNumberMapper.findAreaByPhoneNumber(cdr.getCaller()).getResBillingArea().getBillingArea();
	// String
	// calleeBillingArea=resPhoneNumberMapper.findAreaByPhoneNumber(cdr.getCallee()).getResBillingArea().getBillingArea();
	// /**
	// * 判断主被叫是否均为中原油田电话
	// */
	// Boolean callerIsLocalPhone = !StringUtil.isEmpty(callerBillingArea);
	// Boolean calleeIsLocalPhone = !StringUtil.isEmpty(calleeBillingArea);
	// /**
	// * 当主被叫均为中原油田电话
	// */
	// if(callerIsLocalPhone&&calleeIsLocalPhone){
	// /**
	// * 当主被叫在同一营业区
	// */
	// if(callerBillingArea.equals(calleeBillingArea)){
	// cdr.setCalleeLocation("**油田区内市话**");
	// cdr.setServiceId("4226a366-d3ea-11e6-a136-0894ef0be7f0");
	// }else { //当主被叫不在统一营业区
	// cdr.setCalleeLocation("**油田区间市话**");
	// cdr.setServiceId("423f0eec-d3ea-11e6-a136-0894ef0be7f0");
	// }
	// }
	// } catch (Exception e) {
	// }
	// }
	// return cdrs;
	// }
	public static Cdr filt(Cdr cdr) {
		// TODO Auto-generated method stub
		SqlSession ss = MyBatisSessionFactory.getSession();
		ResPhoneNumberMapper resPhoneNumberMapper = ss
				.getMapper(com.tstar.res.dao.ResPhoneNumberMapper.class);
		try {
			/**
			 * 获取主被叫的营业区域
			 */
			String callerBillingArea = resPhoneNumberMapper
					.findAreaByPhoneNumber(cdr.getCaller()).getResBillingArea()
					.getBillingArea();
			String calleeBillingArea = resPhoneNumberMapper
					.findAreaByPhoneNumber(cdr.getCallee()).getResBillingArea()
					.getBillingArea();
			/**
			 * 判断主被叫是否均为中原油田电话
			 */
			Boolean callerIsLocalPhone = !StringUtil.isEmpty(callerBillingArea);
			Boolean calleeIsLocalPhone = !StringUtil.isEmpty(calleeBillingArea);
			/**
			 * 当主被叫均为中原油田电话
			 */
			if (callerIsLocalPhone && calleeIsLocalPhone) {
				/**
				 * 当主被叫在同一营业区
				 */
				if (callerBillingArea.equals(calleeBillingArea)) {
					cdr.setCalleeLocation("区内市话");
					cdr.setCallType("区内市话");
					cdr.setServiceId("4226a366-d3ea-11e6-a136-0894ef0be7f0");
				} else { // 当主被叫不在统一营业区
					cdr.setCalleeLocation("区间市话");
					cdr.setCallType("区间市话");
					cdr.setServiceId("423f0eec-d3ea-11e6-a136-0894ef0be7f0");
				}
			}
		} catch (Exception e) {
		}

		return cdr;
	}

	public static void main(String[] args) {
		Cdr cdr = new Cdr();
		cdr.setCallee("4874636");
		cdr.setCaller("4875401");
		InnerPhoneFilter.filt(cdr);
		System.out.println(cdr.getServiceId());
		System.out.println(cdr.getCalleeLocation());
		SidRate rate = SidRateBus.findDefaultRate(cdr.getServiceId());
		System.out.println(rate.getPrice() + "--" + rate.getBaseFee());

	}
}
