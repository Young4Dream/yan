package com.tstar.ocs.service;

import java.util.List;

import com.tstar.ocs.model.SidOperator;

public interface SidOperatorService {
	List<SidOperator> selectAll();
	
	String[] insert(SidOperator obj);
	
	String[] update(SidOperator obj);
	
	String[] delete(String id);
}
