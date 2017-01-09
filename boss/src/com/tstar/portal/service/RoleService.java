package com.tstar.portal.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.tstar.portal.model.ResultMap;
import com.tstar.portal.model.Role;

public interface RoleService {

	public  JSONArray menuJson(String roleId);

	public  List<String> checkedId(String id);

	//public  List<Role> selectByExample(Role role);
	
    String[] insert(Role role);
    
    String[] updateByPrimaryKey(Role role);
    
    String[] deleteByPrimaryKey(String id);
    
    String[] menuUpdateByMenuId(String id, String menuChange);
    
	int countByName(Map<String, Object> map);
	
	List<ResultMap> findRoleByPage(Map<String, Object> map);

}