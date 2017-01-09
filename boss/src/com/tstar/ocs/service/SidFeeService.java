/**
 * 
 */
package com.tstar.ocs.service;

import java.util.List;

import com.tstar.ocs.model.SidFee;

/**
 * @author zhumengfeng
 *
 */
public interface SidFeeService {

	List<SidFee> selectByPage(int start, int length);
	
	List<SidFee> selectAll();
	
	List<SidFee> selectOpFee(String opId);
	
	List<SidFee> selectOpFeeByName(String name);
	
	int countAll();
	
	String[] insert(SidFee obj);
	
	String[] update(SidFee obj);
	
	String[] delete(String id);
	
}
