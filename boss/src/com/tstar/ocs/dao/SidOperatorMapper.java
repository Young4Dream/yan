package com.tstar.ocs.dao;

import java.util.List;

import com.tstar.ocs.model.SidOperator;

public interface SidOperatorMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidOperator record);

    int insertSelective(SidOperator record);

    SidOperator selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidOperator record);

    int updateByPrimaryKey(SidOperator record);
    
    List<SidOperator> selectAll();
}