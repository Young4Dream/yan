package com.tstar.ocs.dao;

import java.util.List;

import com.tstar.ocs.model.SidServiceCategory;

public interface SidServiceCategoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidServiceCategory record);

    int insertSelective(SidServiceCategory record);

    SidServiceCategory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidServiceCategory record);

    int updateByPrimaryKey(SidServiceCategory record);
    
    List<SidServiceCategory> selectAll();
    
    SidServiceCategory selectByAbbr(String abbr);
}