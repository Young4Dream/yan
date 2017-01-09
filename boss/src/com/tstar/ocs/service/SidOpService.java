/**
 * 
 */
package com.tstar.ocs.service;

import java.util.List;

import com.tstar.ocs.model.SidOp;

/**
 * @author zhumengfeng
 *
 */
public interface SidOpService {
	
	List<SidOp> selectByPage(int start, int length);
	
	int countAll();
	
	String[] insert(SidOp obj);
	
	String[] update(SidOp obj);
	
	String[] updateModelKey(SidOp obj);
	
	String[] delete(String id);

}
