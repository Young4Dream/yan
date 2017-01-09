package com.tstar.portal.dao;

import java.util.List;

import com.tstar.portal.model.RoleAcl;

public interface RoleAclMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleAcl record);

    int insertSelective(RoleAcl record);

    RoleAcl selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleAcl record);

    int updateByPrimaryKey(RoleAcl record);
    
    List<String> selectMenuIdByRoleId(String roleId);
    
    int deleteByExample(String roleId, String menuId);
}