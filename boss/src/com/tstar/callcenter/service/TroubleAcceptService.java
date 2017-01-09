package com.tstar.callcenter.service;


import java.io.IOException;
import java.util.List;

import com.tstar.callcenter.model.InsertTrouble;
import com.tstar.callcenter.pub.data.ResultMap;


public interface TroubleAcceptService {
	
	public List<ResultMap> findTrouUser(String jobtype, String thiskey, String queryType, String moreField,
	        String exact, int start, int length);
	
	public List<ResultMap> findTrouType(String jobtype);
	
	public List<ResultMap> findTrouHist(String jobtype, String thiskey)throws  IOException;
	
	public int findTrouHistByCount(String jobtype, String thiskey);
	
	public List<ResultMap> findworkFlow(String queryStr);

	public String[] insertTrouble(InsertTrouble insertTrouble);
	
	public int getTrouUserCount();
	
	public void setTrouUserCount(int trouUserCount);
	
	public int getWorkFlowCount();
    
    public void setWorkFlowCount(int workFlowCount);
	
	public ResultMap checkDh(String dh);
	
    public ResultMap checkBroad(String account);
}
