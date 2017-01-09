package com.tstar.ocs.dao;

import java.util.List;

import com.tstar.ocs.model.CdrLog;

public interface CdrLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(CdrLog record);

    int insertSelective(CdrLog record);

    CdrLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CdrLog record);

    int updateByPrimaryKey(CdrLog record);
    
    List<CdrLog> selectByPage(int start, int length);
    
    int countAll();
    
    List<CdrLog> selectByFlag(int flag);
    
    CdrLog selectLastLog(String sourceId, String fileName);
}