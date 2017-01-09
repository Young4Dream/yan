package com.tstar.portal.dao;

import java.util.List;
import java.util.Map;

import com.tstar.portal.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);
    
    User selectByUserName(String userName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int countByRoleId(String roleId);
    
    List<User> selectByRole(String roleName);
    
    int countByCriteria(Map<String, Object> map);
    
    List<User> selectByPage(Map<String, Object> map);
}