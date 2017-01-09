package com.tstar.res.dao;

import java.util.List;
import java.util.Map;

import com.tstar.res.model.ResReport;

public interface ResReportMapper {
    int deleteByPrimaryKey(String id);

    int insert(ResReport record);

    int insertSelective(ResReport record);

    ResReport selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ResReport record);

    int updateByPrimaryKey(ResReport record);
    
    int countByCriteria(Map<String, Object> map);
    
    List<ResReport> selectByPage(Map<String, Object> map);
    
    ResReport selectByKey(String key);
}