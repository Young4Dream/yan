/**
 * 
 */
package com.tstar.res.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.tstar.res.model.ResDept;

/**
 * @author zhumengfeng
 *
 */
public interface ResDeptService {
	
	List<ResDept> selectRoot();
	
	List<ResDept> selectChildren(String parentId);
	
	JSONArray findAll2Tree();
	
	JSONArray findAll2Tree4Choosed();
	
	String[] insert(ResDept obj);
	
	String[] update(ResDept obj);
	
	String[] delete(String id);
	
	String[] deleteByCode(String code);
	
	String nextDeptCode(String parentId);
}
