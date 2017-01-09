package com.tstar.res.dao;

import java.util.List;

import com.tstar.res.model.ResAddress;

public interface ResAddressMapper {
    int deleteByPrimaryKey(String id);

    int insert(ResAddress record);

    int insertSelective(ResAddress record);

    ResAddress selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ResAddress record);

    int updateByPrimaryKey(ResAddress record);
    
    int countByParentId(String parentId);
    
    List<ResAddress> selectAll();
}