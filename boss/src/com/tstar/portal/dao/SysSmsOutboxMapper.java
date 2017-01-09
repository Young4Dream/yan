package com.tstar.portal.dao;

import java.util.List;
import java.util.Map;

import com.tstar.portal.model.SysSmsOutbox;

public interface SysSmsOutboxMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysSmsOutbox record);

    int insertSelective(SysSmsOutbox record);

    SysSmsOutbox selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysSmsOutbox record);

    int updateByPrimaryKey(SysSmsOutbox record);
    
    int countByCriteria(Map<String, Object> map);
    
    List<SysSmsOutbox> selectByPage(Map<String, Object> map);
}