package com.tstar.portal.dao;

import java.util.List;
import java.util.Map;

import com.tstar.portal.model.SysWarnLog;

public interface SysWarnLogMapper {
	
	int countByCriteria(Map<String, Object> map);
	
	List<SysWarnLog> selectByPage(Map<String, Object> map);
	
	List<SysWarnLog> selectTop10();
	
    int deleteByPrimaryKey(String id);

    int insert(SysWarnLog record);

    int insertSelective(SysWarnLog record);

    SysWarnLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysWarnLog record);

    int updateByPrimaryKey(SysWarnLog record);
}