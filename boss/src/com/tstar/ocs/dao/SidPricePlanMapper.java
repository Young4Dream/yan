package com.tstar.ocs.dao;

import java.util.List;
import java.util.Map;

import com.tstar.ocs.model.SidPricePlan;

public interface SidPricePlanMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidPricePlan record);

    int insertSelective(SidPricePlan record);

    SidPricePlan selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidPricePlan record);

    int updateByPrimaryKey(SidPricePlan record);
    
    int countAll(Map<String, Object> map);
    
    List<SidPricePlan> selectByPage(Map<String, Object> map);
    
    List<SidPricePlan> selectReleasedPublicPlan();
    
    List<SidPricePlan> selectOrderableByBusiness(String businessType);
}