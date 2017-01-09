package com.tstar.ac.dao;

import java.util.List;
import java.util.Map;

import com.tstar.ac.model.AcAction;

public interface AcActionMapper {
    int deleteByPrimaryKey(String id);

    int insert(AcAction record);

    int insertSelective(AcAction record);

    AcAction selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AcAction record);

    int updateByPrimaryKey(AcAction record);
    
    AcAction selectTopByStatus(Integer status);
    
    AcAction selectTopRunnable();
    
    int updateStatusByJobId(String jobId, Integer status);
    
    int updateStatusByPrimaryKey(String actionId);
    
    int countByCriteria(Map<String, Object> map);
    
    List<AcAction> selectByPage(Map<String, Object> map);
    
    List<AcAction> selectByInstanceId(String isntanceId);
}