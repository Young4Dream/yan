package com.tstar.ac.dao;

import java.util.List;

import com.tstar.ac.model.AcCommand;

public interface AcCommandMapper {
    int deleteByPrimaryKey(String id);

    int insert(AcCommand record);

    int insertSelective(AcCommand record);

    AcCommand selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AcCommand record);

    int updateByPrimaryKey(AcCommand record);
    
    List<AcCommand> selectByActionId(String actionId);
    
    int deleteByActionId(String actionId);
}