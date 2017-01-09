package com.tstar.ocs.dao;

import java.util.List;

import com.tstar.ocs.model.SidService;

public interface SidServiceMapper {
    int deleteByPrimaryKey(String id);

    int insert(SidService record);

    int insertSelective(SidService record);

    SidService selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SidService record);

    int updateByPrimaryKey(SidService record);
    
    int countAll();
    
    List<SidService> selectByPage(int start, int length);
    
    List<SidService> selectAll();
}