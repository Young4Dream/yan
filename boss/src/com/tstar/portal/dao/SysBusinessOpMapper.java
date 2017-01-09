package com.tstar.portal.dao;

import java.util.List;

import com.tstar.portal.model.SysBusinessOp;

public interface SysBusinessOpMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysBusinessOp record);

    int insertSelective(SysBusinessOp record);

    SysBusinessOp selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysBusinessOp record);

    int updateByPrimaryKey(SysBusinessOp record);
    
    int countAll();
    
    List<SysBusinessOp> selectByPage(int start, int length);
    
    SysBusinessOp selectByBusiKey(String busiKey);
}