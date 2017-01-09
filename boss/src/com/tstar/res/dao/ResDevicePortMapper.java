package com.tstar.res.dao;

import java.util.List;
import java.util.Map;

import com.tstar.res.model.ResDevicePort;

public interface ResDevicePortMapper {
    int deleteByPrimaryKey(String id);

    int insert(ResDevicePort record);

    int insertSelective(ResDevicePort record);

    ResDevicePort selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ResDevicePort record);

    int updateByPrimaryKey(ResDevicePort record);
    
    int countByCriteria(Map<String, Object> criteria);
    
    int countByDevice(String deviceCode);
    
    List<ResDevicePort> selectByPage(Map<String, Object> criteria);
    
    int countUsable(Map<String, Object> criteria);
    
    List<ResDevicePort> selectUsable(Map<String, Object> criteria);
    
    ResDevicePort selectByCode(String deviceCode, String portCode);
    
}