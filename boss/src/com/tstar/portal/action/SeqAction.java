/**
 * 
 */
package com.tstar.portal.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.portal.service.SysSequenceService;

/**
 * @author zhumengfeng
 *
 */
public class SeqAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource 
	private SysSequenceService service;
	
	private String seqVal;
	
	private String policyKey;

	public String currVal() {
		seqVal = service.currVal(policyKey);
		return "getRecords";
	}
	
	public String nextVal() {
		service.nextVal(policyKey, seqVal);
		return "getRecords";
	}

	public String getPolicyKey() {
		return policyKey;
	}

	public void setPolicyKey(String policyKey) {
		this.policyKey = policyKey;
	}

	public String getSeqVal() {
		return seqVal;
	}

	public void setSeqVal(String seqVal) {
		this.seqVal = seqVal;
	}
}
