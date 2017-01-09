/**
 * 
 */
package com.tstar.billing.business;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import com.tstar.portal.dao.SysSequencePolicyMapper;
import com.tstar.portal.model.SysSequencePolicy;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
public class SysSequenceBus {

	private synchronized static String fetchCurrVal(SqlSession session, String policyKey, Date dt) {
		
		Date termDate = (dt == null ? new Date() : dt);
		SysSequencePolicyMapper daoPolicy = session.getMapper(SysSequencePolicyMapper.class);
		SysSequencePolicy policy = daoPolicy.selectByPolicyKey(policyKey);
		if (policy == null) { return ""; }
		String exp = policy.getPolicyExp();
		if (StringUtil.isEmpty(exp)) { return ""; }
		String[] us = exp.split(";");
		String currPrefix = "";
		String seqPattern = "";
		for (int i = 0; i < us.length; i++) {
			String head = us[i].substring(0, 1).toLowerCase();
			String tail = us[i].substring(1);
			if ("c".equals(head)) {
				currPrefix += tail;
			} else if ("d".equals(head)) {
				currPrefix += (new SimpleDateFormat(tail)).format(termDate);
			} else if ("n".equals(head)) {
				seqPattern = tail;
			} else {
				continue;
			}
		}
		
		// 没有流水号，返回常数编号
		if (StringUtil.isEmpty(seqPattern)) { return currPrefix; }
		
		String lastPrefix = policy.getCurrPrefix();
		boolean reset = false;
		if (StringUtil.isEmpty(currPrefix)) {
			if (StringUtil.isEmpty(policy.getCurrSeq())) {
				reset = true;
			} else {
				reset = false;
			}
		} else {
			if (StringUtil.isEmpty(lastPrefix) || !currPrefix.equals(lastPrefix)) {
				reset = true;
			} else {
				reset = false;
			}
		}
		
		policy.setCurrPrefix(currPrefix);
		if (reset) {
			policy.setCurrSeq(seqPattern);
		} else {
			int len = seqPattern.length();
			int nextVal = Integer.parseInt(policy.getCurrSeq()) + 1;
			int max = Integer.parseInt(StringUtil.join("9", len));
			if (nextVal > max) {
				nextVal = Integer.parseInt(seqPattern);
			}
			DecimalFormat df = new DecimalFormat(StringUtil.join("0", len));
			policy.setCurrSeq(df.format(nextVal));
		}
		daoPolicy.updateByPrimaryKey(policy);
		
		return currPrefix + policy.getCurrSeq();
	}
	
	public static String currVal(SqlSession session, String policyKey, Date dt) {
		return fetchCurrVal(session, policyKey, dt);
	}
	
	public static String currVal(SqlSession session, String policyKey) {
		return fetchCurrVal(session, policyKey, null);
	}
	
}
