package com.tstar.ocs.dao;

import java.util.List;

import com.tstar.ocs.model.SidDataConfig;

public interface SidDataConfigMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidDataConfig record);

    int insertSelective(SidDataConfig record);

    SidDataConfig selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidDataConfig record);

    int updateByPrimaryKey(SidDataConfig record);
    
    List<SidDataConfig> selectAll();
}