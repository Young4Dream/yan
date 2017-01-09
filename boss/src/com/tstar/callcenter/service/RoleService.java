package com.tstar.callcenter.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.tstar.callcenter.model.autogenerate.RoleInfo;
import com.tstar.callcenter.pub.data.ResultMap;

public interface RoleService {

	public  JSONArray menuJson(List<Long> checkedId);

	public  List<Long> checkedId(long roleId);

	public  List<RoleInfo> selectByExample(RoleInfo roleInfo);
	
    String[] insert(RoleInfo roleInfo);
    
    String[] updateByPrimaryKey(RoleInfo roleInfo);
    
    String[] deleteByPrimaryKey(long roleId);
    
    String[] menuUpdateByMenuId(long roleId,String menuChange);
    
	List<ResultMap>findRoleByPage(RoleInfo roleInfo,int start,int length);
	
	int findRoleByCount(RoleInfo roleInfo);

}