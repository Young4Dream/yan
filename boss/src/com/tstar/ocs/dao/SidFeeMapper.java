package com.tstar.ocs.dao;

import java.util.List;

import com.tstar.ocs.model.SidFee;

public interface SidFeeMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidFee record);

    int insertSelective(SidFee record);

    SidFee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidFee record);

    int updateByPrimaryKey(SidFee record);
    
    int countAll();
    
    List<SidFee> selectByPage(int start, int length);
    
    List<SidFee> selectAll();
    
    List<SidFee> selectOpFee(String opId);
    
}