package com.tstar.portal.dao;

import java.util.List;
import java.util.Map;

public interface RefMapper {
    int deleteByPrimaryKey(Map<String, String> map);

    int insert(Map<String, String> record);

    Map<String, String> selectByPrimaryKey(Map<String, String> map);

    int updateByPrimaryKey(Map<String, String> record);
    
    List<Map<String, String>> selectAll(Map<String, String> map);
}