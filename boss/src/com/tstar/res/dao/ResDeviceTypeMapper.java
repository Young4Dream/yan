package com.tstar.res.dao;

import java.util.List;

import com.tstar.res.model.ResDeviceType;

public interface ResDeviceTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(ResDeviceType record);

    int insertSelective(ResDeviceType record);

    ResDeviceType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ResDeviceType record);

    int updateByPrimaryKey(ResDeviceType record);
    
    List<ResDeviceType> selectAll();
}