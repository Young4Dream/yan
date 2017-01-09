/**
 * 
 */
package com.tstar.portal.service;

import java.util.Date;

/**
 * @author zhumengfeng
 *
 */
public interface SysSequenceService {

	// 获取当前编号值并锁定
	String currVal(String policyKey);
	
	// 获取当前编号值并锁定
	String currVal(String policyKey, Date dt);
	
	// 删除编号值
	void nextVal(String policyKey, String seqVal);
	
	// 解锁已锁定超过一天的编号
	void unlock();
}
