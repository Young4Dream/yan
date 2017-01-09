package com.tstar.ocs.dao;

import java.util.List;

import com.tstar.ocs.model.SidProduct;

public interface SidProductMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidProduct record);

    int insertSelective(SidProduct record);

    SidProduct selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidProduct record);

    int updateByPrimaryKey(SidProduct record);
    
    List<SidProduct> selectByPage(int start, int length);
    
    int countAll();
    
    List<SidProduct> selectRoot();
    
    List<SidProduct> selectChildren();
    
    List<SidProduct> selectChildrenByPage(String parentId, int start, int length);
    
    int countChildren(String parentId);
}