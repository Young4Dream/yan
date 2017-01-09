package com.tstar.portal.dao;

import java.util.List;

import com.tstar.portal.model.SysAccountItem;

public interface SysAccountItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysAccountItem record);

    int insertSelective(SysAccountItem record);

    SysAccountItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysAccountItem record);

    int updateByPrimaryKey(SysAccountItem record);
    
    List<SysAccountItem> selectAll();
    
    int deleteByCode(String code);
}