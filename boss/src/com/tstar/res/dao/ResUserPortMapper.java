package com.tstar.res.dao;

import java.util.List;

import com.tstar.res.model.ResUserPort;

public interface ResUserPortMapper {
    int deleteByPrimaryKey(String id);

    int insert(ResUserPort record);

    int insertSelective(ResUserPort record);

    ResUserPort selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ResUserPort record);

    int updateByPrimaryKey(ResUserPort record);
    
    List<ResUserPort> selectByUserId(String userId);
    
    Integer selectMaxPortIndex(String userId);
}