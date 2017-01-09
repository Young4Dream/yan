package com.tstar.portal.dao;

import java.util.List;
import java.util.Map;

import com.tstar.portal.model.SysNotice;

public interface SysNoticeMapper {
	
	int countByCriteria(Map<String, Object> map);
	
	List<SysNotice> selectByPage(Map<String, Object> map);
	
	List<SysNotice> selectTop10();
	
    int deleteByPrimaryKey(String id);

    int insert(SysNotice record);

    int insertSelective(SysNotice record);

    SysNotice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysNotice record);

    int updateByPrimaryKey(SysNotice record);
}