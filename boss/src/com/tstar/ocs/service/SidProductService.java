/**
 * 
 */
package com.tstar.ocs.service;

import java.util.List;

import com.tstar.ocs.model.SidProduct;

/**
 * @author zhumengfeng
 *
 */
public interface SidProductService {
	
	List<SidProduct> selectByPage(int start, int length);
	
	List<SidProduct> selectRoot();
	
	List<SidProduct> selectChildren();
	
	int countAll();
	
	String[] insert(SidProduct obj);
	
	String[] update(SidProduct obj);
	
	String[] delete(String id);
	
	List<SidProduct> selectChildrenByPage(String parentId, int start, int length);
	
	int countChildren(String parentId);
}
