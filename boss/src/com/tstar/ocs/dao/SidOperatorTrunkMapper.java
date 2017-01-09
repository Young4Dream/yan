package com.tstar.ocs.dao;

import java.util.List;

import com.tstar.ocs.model.SidOperatorTrunk;

public interface SidOperatorTrunkMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidOperatorTrunk record);

    int insertSelective(SidOperatorTrunk record);

    SidOperatorTrunk selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidOperatorTrunk record);

    int updateByPrimaryKey(SidOperatorTrunk record);
    
    List<SidOperatorTrunk> selectByOpId(String opId);
    
    int deleteByOpId(String opId);
    
    List<SidOperatorTrunk> selectAll();
}