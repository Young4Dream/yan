package com.tstar.portal.service;

import java.util.List;

import com.tstar.portal.model.Dept;
import com.tstar.portal.model.ResultMap;

public interface DeptService {
	
	List<ResultMap> getAllDepts();
	
	String[] deleteByCode(String code);
	
	String[] insert(Dept obj);
	
	String[] update(Dept obj);
}
