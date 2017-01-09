package com.tstar.crm.dao;

import com.tstar.crm.model.CrmUserBroad;

public interface CrmUserBroadMapper {
    int deleteByPrimaryKey(String id);

    int insert(CrmUserBroad record);

    int insertSelective(CrmUserBroad record);

    CrmUserBroad selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CrmUserBroad record);

    int updateByPrimaryKey(CrmUserBroad record);
}