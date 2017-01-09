/**
 * 
 */
package com.tstar.billing.model;

import java.util.List;

import com.tstar.ocs.model.Cdr;
import com.tstar.ocs.model.CdrLog;

/**
 * @author zhumengfeng
 *
 */
public class Job {

	public CdrLog log;
	public List<Cdr> cdrs;
	
	public Job() {}
	
	public Job(CdrLog log, List<Cdr> cdrs) {
		this.log = log;
		this.cdrs = cdrs;
	}
}
