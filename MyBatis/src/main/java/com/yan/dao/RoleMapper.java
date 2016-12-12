package com.yan.dao;

import java.util.Map;

import com.yan.po.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    /*Role selectByUnionKey(Map<String,Object> map);*/
    
    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}