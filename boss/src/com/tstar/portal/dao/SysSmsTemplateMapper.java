package com.tstar.portal.dao;

import java.util.List;

import com.tstar.portal.model.SysSmsTemplate;

public interface SysSmsTemplateMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysSmsTemplate record);

    int insertSelective(SysSmsTemplate record);

    SysSmsTemplate selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysSmsTemplate record);

    int updateByPrimaryKey(SysSmsTemplate record);
    
    List<SysSmsTemplate> selectByUser(String userName);
}