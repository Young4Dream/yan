package com.tstar.crm.dao;

import com.tstar.crm.model.JobOpInstance;

public interface JobOpInstanceMapper {
    int deleteByPrimaryKey(String id);

    int insert(JobOpInstance record);

    int insertSelective(JobOpInstance record);

    JobOpInstance selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JobOpInstance record);

    int updateByPrimaryKey(JobOpInstance record);
}