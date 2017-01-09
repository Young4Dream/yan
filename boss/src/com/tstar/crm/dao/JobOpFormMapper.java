package com.tstar.crm.dao;

import java.util.List;
import java.util.Map;

import com.tstar.crm.model.JobOpForm;

public interface JobOpFormMapper {
    int deleteByPrimaryKey(String id);

    int insert(JobOpForm record);

    int insertSelective(JobOpForm record);

    JobOpForm selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JobOpForm record);

    int updateByPrimaryKey(JobOpForm record);
    
    int countByCriteria(Map<String, Object> map);
    
    List<JobOpForm> selectByPage(Map<String, Object> map);
    
    int countByInstanceId(String instanceId);
    
    JobOpForm selectByInstanceId(String instanceId);
}