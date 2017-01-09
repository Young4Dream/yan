package com.tstar.crm.dao;

import com.tstar.crm.model.CrmUserPl;

public interface CrmUserPlMapper {
    int deleteByPrimaryKey(String id);

    int insert(CrmUserPl record);

    int insertSelective(CrmUserPl record);

    CrmUserPl selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CrmUserPl record);

    int updateByPrimaryKey(CrmUserPl record);
}