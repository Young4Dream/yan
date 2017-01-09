/**
 * 
 */
package com.tstar.crm.service;

import java.util.List;
import java.util.Map;

import com.tstar.crm.model.JobOpForm;

/**
 * @author zhumengfeng
 *
 */
public interface JobOpFormService {

	List<JobOpForm> findByPage(Map<String, Object> map);
	
	int countByCriteria(Map<String, Object> map);
	
	JobOpForm generate(String instanceId);
	
	String[] insert(JobOpForm obj);
	
	String[] update(JobOpForm obj);
	
}
