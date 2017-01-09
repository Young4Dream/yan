package com.tstar.portal.dao;

import java.util.List;
import java.util.Map;

import com.tstar.portal.model.ResultMap;
import com.tstar.portal.model.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    int countAll();
    
    List<ResultMap> selectAllRole();
    
    int countByCriteria(Map<String, Object> map);
    
    List<ResultMap> selectByPage(Map<String, Object> map);
}