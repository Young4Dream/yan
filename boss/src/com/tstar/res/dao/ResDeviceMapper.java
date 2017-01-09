package com.tstar.res.dao;

import java.util.List;
import java.util.Map;

import com.tstar.res.model.ResDevice;

public interface ResDeviceMapper {
    int deleteByPrimaryKey(String id);

    int insert(ResDevice record);

    int insertSelective(ResDevice record);

    ResDevice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ResDevice record);

    int updateByPrimaryKey(ResDevice record);
    
    int countByCriteria(Map<String, Object> criteria);
    
    List<ResDevice> selectByPage(Map<String, Object> criteria);
    
    ResDevice selectByCode(String deviceCode);
    
}