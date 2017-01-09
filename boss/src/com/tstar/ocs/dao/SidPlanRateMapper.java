package com.tstar.ocs.dao;

import java.util.List;

import com.tstar.ocs.model.SidPlanRate;

public interface SidPlanRateMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidPlanRate record);

    int insertSelective(SidPlanRate record);

    SidPlanRate selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidPlanRate record);

    int updateByPrimaryKey(SidPlanRate record);

    List<SidPlanRate> selectByPlanId(String planId);
}