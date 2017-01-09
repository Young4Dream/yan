package com.tstar.crm.dao;

import java.util.List;
import java.util.Map;

import com.tstar.crm.model.OcsAccountLog;

public interface OcsAccountLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(OcsAccountLog record);

    int insertSelective(OcsAccountLog record);

    OcsAccountLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OcsAccountLog record);

    int updateByPrimaryKey(OcsAccountLog record);
    
    int countByCriteria(Map<String, Object> map);
    
    List<Map<String, Object>> selectByPage(Map<String, Object> map);
}