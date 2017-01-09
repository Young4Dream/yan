package com.tstar.ocs.dao;

import java.util.List;

import com.tstar.ocs.model.CdrSource;

public interface CdrSourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(CdrSource record);

    int insertSelective(CdrSource record);

    CdrSource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CdrSource record);

    int updateByPrimaryKey(CdrSource record);
    
    List<CdrSource> selectAll();
    
    List<CdrSource> selectByStatus(int status);
}