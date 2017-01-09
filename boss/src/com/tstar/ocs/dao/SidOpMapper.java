package com.tstar.ocs.dao;

import java.util.List;

import com.tstar.ocs.model.SidOp;

public interface SidOpMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidOp record);

    int insertSelective(SidOp record);

    SidOp selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidOp record);

    int updateByPrimaryKey(SidOp record);
    
    int countAll();
    
    List<SidOp> selectByPage(int start, int length);
    
    int deleteOpFee(String id);
    
    int insertOpFee(String id, String opId, String feeId);
    
    SidOp selectByName(String name);
}