package com.tstar.callcenter.service;

import java.util.List;

import com.tstar.callcenter.pub.data.ResultMap;

public interface SystemConfService {

	public List<ResultMap> selectSystemConf();
	
	public String[] updateSystemConf(int saveTime ,String systemIp, String gwIp); 
	
	public List<ResultMap> selectSystemIp();
}
