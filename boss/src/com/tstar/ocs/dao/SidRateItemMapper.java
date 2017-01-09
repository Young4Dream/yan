package com.tstar.ocs.dao;

import java.util.List;

import com.tstar.ocs.model.SidRateItem;

public interface SidRateItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidRateItem record);

    int insertSelective(SidRateItem record);

    SidRateItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidRateItem record);

    int updateByPrimaryKey(SidRateItem record);
    
    List<SidRateItem> selectByRateId(String rateId);
    
    int deleteByRateId(String rateId);
}