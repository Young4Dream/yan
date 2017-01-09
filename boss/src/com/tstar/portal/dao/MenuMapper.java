package com.tstar.portal.dao;

import java.util.List;
import java.util.Map;

import com.tstar.portal.model.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    List<Menu> selectByRoleId(String roleId);
    
    List<Menu> selectAll();
    
    int countChild(String parentId);
    
    List<Map<String, Object>> selectAllHasRole(String roleId);
}