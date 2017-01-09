package com.tstar.ocs.dao;

import java.util.List;

import com.tstar.ocs.model.SidMaterial;

public interface SidMaterialMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidMaterial record);

    int insertSelective(SidMaterial record);

    SidMaterial selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidMaterial record);

    int updateByPrimaryKey(SidMaterial record);
    
    List<SidMaterial> selectAll();
}