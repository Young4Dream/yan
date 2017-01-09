package com.tstar.callcenter.service;

import java.util.List;

import com.tstar.callcenter.model.QueryNum;
import com.tstar.callcenter.model.autogenerate.Query114User;
import com.tstar.callcenter.pub.data.ResultMap;

public interface Query114Service {

	public List<ResultMap> query114List(Query114User query114User,int start,int length);
	
	public int selectAll114Count(Query114User query114User);
	
	public int queryNumInsert(QueryNum queryNum);
	
	public int queryNumUpdate(QueryNum queryNum);
	
	public int queryNumDelete(QueryNum queryNum);
}
