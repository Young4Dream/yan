package com.tstar.ocs.service;

import java.util.List;

import com.tstar.ocs.model.SidVoiceConfigItem;

public interface SidVoiceConfigItemService {
	List<SidVoiceConfigItem> selectByConfigId(String configId);
	
	String[] insert(SidVoiceConfigItem obj);
	
	String[] update(SidVoiceConfigItem obj);
	
	String[] delete(String id);
}
