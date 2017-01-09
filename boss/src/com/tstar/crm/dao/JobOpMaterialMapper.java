package com.tstar.crm.dao;

import java.util.List;

import com.tstar.crm.model.JobOpMaterial;

public interface JobOpMaterialMapper {
    int deleteByPrimaryKey(String id);

    int insert(JobOpMaterial record);

    int insertSelective(JobOpMaterial record);

    JobOpMaterial selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JobOpMaterial record);

    int updateByPrimaryKey(JobOpMaterial record);
    
    List<JobOpMaterial> selectByFormId(String formId);
}