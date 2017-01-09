package com.tstar.callcenter.service;

import java.util.List;

import com.tstar.callcenter.model.autogenerate.RecordHistroy;
import com.tstar.callcenter.pub.data.ResultMap;

public interface RecordService {
	
	
	public List<ResultMap> selectRecordList(RecordHistroy recordHist, String startTime, String endTime, int start, int length);
	
	public int selectAllRecordCount(RecordHistroy recordHist, String startTime, String endTime);
	
	
	
	

}
