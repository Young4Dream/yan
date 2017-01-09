package com.tstar.ocs.dao;

import java.util.List;

import com.tstar.ocs.model.SidVoiceConfigItem;

public interface SidVoiceConfigItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidVoiceConfigItem record);

    int insertSelective(SidVoiceConfigItem record);

    SidVoiceConfigItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidVoiceConfigItem record);

    int updateByPrimaryKey(SidVoiceConfigItem record);
    
    List<SidVoiceConfigItem> selectByConfigId(String configId);
    
    SidVoiceConfigItem selectDefaultConfigItem();
    
    List<SidVoiceConfigItem> selectAllOrderByLen();
}