package com.tstar.ocs.dao;

import java.util.List;
import java.util.Map;

import com.tstar.ocs.model.SidRate;

public interface SidRateMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidRate record);

    int insertSelective(SidRate record);

    SidRate selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidRate record);

    int updateByPrimaryKey(SidRate record);
    
    int countAll(Map<String, Object> map);
    
    List<SidRate> selectAll();
    
    List<SidRate> selectByPage(Map<String, Object> map);
    
    List<SidRate> selectDefaultRates();
}