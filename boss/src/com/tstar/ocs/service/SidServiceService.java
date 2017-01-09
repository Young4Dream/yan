package com.tstar.ocs.service;

import java.util.List;

import com.tstar.ocs.model.SidService;

public interface SidServiceService {
	int countAll();
	
	List<SidService> selectByPage(int start, int length);
	
	String[] insert(SidService obj);
	
	String[] update(SidService obj);
	
	String[] delete(String id);
}
