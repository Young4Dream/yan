/**
 * 
 */
package com.tstar.portal.service;

import java.util.List;

import com.tstar.portal.model.SysBusinessOp;

/**
 * @author zhumengfeng
 *
 */
public interface SysBusinessOpService {

	int countAll();
	
	List<SysBusinessOp> selectByPage(int start, int length);
	
	String[] update(SysBusinessOp obj);
}
