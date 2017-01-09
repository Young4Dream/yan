package com.tstar.crm.dao;

import java.util.List;

import com.tstar.crm.model.JobOpWorkload;

public interface JobOpWorkloadMapper {
    int deleteByPrimaryKey(String id);

    int insert(JobOpWorkload record);

    int insertSelective(JobOpWorkload record);

    JobOpWorkload selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JobOpWorkload record);

    int updateByPrimaryKey(JobOpWorkload record);
    
    List<JobOpWorkload> selectByFormId(String formId);
}