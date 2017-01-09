package com.tstar.ocs.dao;

import java.util.List;

import com.tstar.ocs.model.SidOperatorRate;

public interface SidOperatorRateMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidOperatorRate record);

    int insertSelective(SidOperatorRate record);

    SidOperatorRate selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidOperatorRate record);

    int updateByPrimaryKey(SidOperatorRate record);
    
    List<SidOperatorRate> selectByOpId(String opId);
    
    int deleteByOpId(String opId);
    
    List<SidOperatorRate> selectAll();
}