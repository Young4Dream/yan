/**
 * 
 */
package com.tstar.crm.service;

import java.util.List;

import com.tstar.crm.model.JobOpWorkload;

/**
 * @author zhumengfeng
 *
 */
public interface JobOpWorkloadService {
	
	List<JobOpWorkload> findByFormId(String formId);
	
	String[] insert(JobOpWorkload obj);
	
	String[] delete(String id);
	
}
