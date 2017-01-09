package com.tstar.ocs.service;

import java.util.List;

import com.tstar.ocs.model.CdrSource;

public interface CdrSourceService {
	
	List<CdrSource> selectAll();
	
	String[] insert(CdrSource obj);
	
	String[] update(CdrSource obj);
	
	String[] delete(String id);
}
