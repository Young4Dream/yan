/**
 * 
 */
package com.tstar.portal.service.impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.portal.dao.SysSequencePolicyMapper;
import com.tstar.portal.dao.SysSequencePoolMapper;
import com.tstar.portal.model.SysSequencePolicy;
import com.tstar.portal.model.SysSequencePool;
import com.tstar.portal.service.SysSequenceService;
import com.tstar.util.StringUtil;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class SysSequenceServiceImpl implements SysSequenceService {

	@Resource
	private SysSequencePolicyMapper daoPolicy;
	
	@Resource
	private SysSequencePoolMapper daoPool;
	
	private String fetchCurrVal(String policyKey, Date dt) {
		Date termDate = (dt == null ? new Date() : dt);
		SysSequencePolicy policy = daoPolicy.selectByPolicyKey(policyKey);
		if (policy == null) { return ""; }
		String exp = policy.getPolicyExp();
		if (StringUtil.isEmpty(exp)) { return ""; }
		String[] us = exp.split(";");
		String seqPattern = "";
		String[] fixPart = new String[2];
		fixPart[0] = "";
		fixPart[1] = "";
		int currPart = 0;
		for (int i = 0; i < us.length; i++) {
			String head = us[i].substring(0, 1).toLowerCase();
			String tail = us[i].substring(1);
			if ("c".equals(head)) {
				//currPrefix += tail;
				fixPart[currPart] += tail;
			} else if ("d".equals(head)) {
				fixPart[currPart] += (new SimpleDateFormat(tail)).format(termDate);
			} else if ("n".equals(head)) {
				seqPattern = tail;
				currPart = 1;
			} else {
				continue;
			}
		}
		String currPrefix = fixPart[0] + fixPart[1];
		
		// 没有流水号，返回常数编号
		if (StringUtil.isEmpty(seqPattern)) { return currPrefix; }
		
		// 从缓冲池取编号历史
		SysSequencePool pool = daoPool.selectTopOneByPolicyKey(policyKey, currPrefix);
		String currVal = pool == null ? seqPattern : pool.getCurrVal();
		int currSeq = Integer.parseInt(currVal);
		int len = seqPattern.length();
		int max = Integer.parseInt(StringUtil.join("9", len));
		int nextSeq = currSeq + 1;
		if (nextSeq > max) {
			nextSeq = Integer.parseInt(seqPattern) + 1;
		}
		DecimalFormat df = new DecimalFormat(StringUtil.join("0", len));
		String nextVal = df.format(nextSeq);
		
		if (pool == null) {
			pool = new SysSequencePool();
			pool.setId(UUID.get());
			pool.setPolicyKey(policyKey);
			pool.setCurrVal(nextVal);
			pool.setCurrPrefix(currPrefix);
			daoPool.insert(pool);
		} else {
			pool.setCurrVal(nextVal);
			daoPool.updateByPrimaryKey(pool);
		}
		
		return fixPart[0] + nextVal + fixPart[1];

		/*
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
		
		pool = new SysSequencePool();
		pool.setId(UUID.get());
		pool.setPolicyKey(policyKey);
		pool.setCurrPrefix(currPrefix);
		pool.setLocked(1);
		pool.setLockTime(new Date());
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
		pool.setCurrVal(currPrefix + policy.getCurrSeq());
		daoPool.insert(pool);
		daoPolicy.updateByPrimaryKey(policy);
		
		return pool.getCurrVal();
		*/
	}
	
	public synchronized String currVal(String policyKey, Date dt) {
		return fetchCurrVal(policyKey, dt);
	}
	
	public synchronized String currVal(String policyKey) {
		return fetchCurrVal(policyKey, null);
	}
	
	public void nextVal(String policyKey, String seqValue) {
		daoPool.deleteByPolicyKeyAndValue(policyKey, seqValue);
	}
	
	public void unlock() {
		daoPool.unlock();
	}

}
