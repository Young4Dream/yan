package com.tstar.ocs.service;

import java.util.List;

import com.tstar.ocs.model.SidDataConfig;

public interface SidDataConfigService {
	List<SidDataConfig> selectAll();
	
	String[] insert(SidDataConfig obj);
	
	String[] update(SidDataConfig obj);
	
	String[] delete(String id);
}
