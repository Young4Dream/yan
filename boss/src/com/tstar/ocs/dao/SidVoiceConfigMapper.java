package com.tstar.ocs.dao;

import java.util.List;

import com.tstar.ocs.model.SidVoiceConfig;

public interface SidVoiceConfigMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidVoiceConfig record);

    int insertSelective(SidVoiceConfig record);

    SidVoiceConfig selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidVoiceConfig record);

    int updateByPrimaryKey(SidVoiceConfig record);
    
    List<SidVoiceConfig> selectAll();
}