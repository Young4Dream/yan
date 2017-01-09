package com.tstar.ocs.service;

import java.util.List;

import com.tstar.ocs.model.SidVoiceConfig;

public interface SidVoiceConfigService {
	List<SidVoiceConfig> selectAll();
	
	String[] insert(SidVoiceConfig obj);
	
	String[] update(SidVoiceConfig obj);
	
	String[] delete(String id);
}
