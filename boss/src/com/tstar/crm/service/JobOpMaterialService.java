/**
 * 
 */
package com.tstar.crm.service;

import java.util.List;

import com.tstar.crm.model.JobOpMaterial;

/**
 * @author zhumengfeng
 *
 */
public interface JobOpMaterialService {

	List<JobOpMaterial> findByFormId(String formId);
	
	String[] insert(JobOpMaterial obj);
	
	String[] delete(String id);
	
}
