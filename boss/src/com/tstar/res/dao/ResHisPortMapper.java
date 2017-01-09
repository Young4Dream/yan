package com.tstar.res.dao;

import com.tstar.res.model.ResHisPort;

public interface ResHisPortMapper {
    int deleteByPrimaryKey(String id);

    int insert(ResHisPort record);

    int insertSelective(ResHisPort record);

    ResHisPort selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ResHisPort record);

    int updateByPrimaryKey(ResHisPort record);
}