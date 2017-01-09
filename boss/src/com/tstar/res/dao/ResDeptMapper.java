package com.tstar.res.dao;

import java.util.List;

import com.tstar.res.model.ResDept;

public interface ResDeptMapper {
    int deleteByPrimaryKey(String id);

    int insert(ResDept record);

    int insertSelective(ResDept record);

    ResDept selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ResDept record);

    int updateByPrimaryKey(ResDept record);
    
    int deleteByCode(String code);
    
    List<ResDept> selectRoot();
    
    List<ResDept> selectAll();
    
    List<ResDept> selectChildren(String parentId);
    
    String selectRootMaxDeptCode();
    
    String selectMaxDeptCode(String parentId);
}