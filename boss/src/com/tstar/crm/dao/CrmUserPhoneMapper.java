package com.tstar.crm.dao;

import com.tstar.crm.model.CrmUserPhone;

public interface CrmUserPhoneMapper {
    int deleteByPrimaryKey(String id);

    int insert(CrmUserPhone record);

    int insertSelective(CrmUserPhone record);

    CrmUserPhone selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CrmUserPhone record);

    int updateByPrimaryKey(CrmUserPhone record);
}