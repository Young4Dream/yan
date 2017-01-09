package com.tstar.billing.business;

import java.util.Map;

import com.tstar.ocs.model.SidVoiceConfigItem;

public class PrefixMap {
	public int length;
	public Map<String, SidVoiceConfigItem> map;
	
	public PrefixMap() {}
	public PrefixMap(int length, Map<String, SidVoiceConfigItem> map) {
		this.length = length;
		this.map = map;
	}
}
