package com.tstar.ocs.dao;

import java.util.Date;
import java.util.List;

import com.tstar.ocs.model.SidDiscount;

public interface SidDiscountMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidDiscount record);

    int insertSelective(SidDiscount record);

    SidDiscount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidDiscount record);

    int updateByPrimaryKey(SidDiscount record);
    
    List<SidDiscount> selectRateDiscountByDateTime(String rateId, Date dt, String timeCode);
}