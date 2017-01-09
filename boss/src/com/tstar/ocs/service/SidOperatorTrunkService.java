package com.tstar.ocs.service;

import java.util.List;

import com.tstar.ocs.model.SidOperatorTrunk;

public interface SidOperatorTrunkService {
	List<SidOperatorTrunk> selectByFk(String fk);
	
	String[] insert(SidOperatorTrunk obj);
	
	String[] update(SidOperatorTrunk obj);
	
	String[] delete(String id);
}
