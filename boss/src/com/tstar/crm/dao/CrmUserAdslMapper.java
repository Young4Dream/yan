package com.tstar.crm.dao;

import com.tstar.crm.model.CrmUserAdsl;

public interface CrmUserAdslMapper {
    int deleteByPrimaryKey(String id);

    int insert(CrmUserAdsl record);

    int insertSelective(CrmUserAdsl record);

    CrmUserAdsl selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CrmUserAdsl record);

    int updateByPrimaryKey(CrmUserAdsl record);
}