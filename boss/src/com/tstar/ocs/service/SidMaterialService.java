/**
 * 
 */
package com.tstar.ocs.service;

import java.util.List;

import com.tstar.ocs.model.SidMaterial;

/**
 * @author zhumengfeng
 *
 */
public interface SidMaterialService {
	
	List<SidMaterial> findAll();

	String[] insert(SidMaterial obj);
	
	String[] update(SidMaterial obj);
	
	String[] delete(String id);
	
}
