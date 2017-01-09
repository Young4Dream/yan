package com.tstar.ocs.dao;

import com.tstar.ocs.model.SidRateDiscount;

public interface SidRateDiscountMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidRateDiscount record);

    int insertSelective(SidRateDiscount record);

    SidRateDiscount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidRateDiscount record);

    int updateByPrimaryKey(SidRateDiscount record);
    
}