package com.yan.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yan.po.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

//  Role selectByUnionKey(Map<String,Object> map);
    Role selectByUnionKey(@Param("roleName") String roleName,@Param("id") Integer id);
    
    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}