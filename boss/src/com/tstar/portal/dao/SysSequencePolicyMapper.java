package com.tstar.portal.dao;

import com.tstar.portal.model.SysSequencePolicy;

public interface SysSequencePolicyMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysSequencePolicy record);

    int insertSelective(SysSequencePolicy record);

    SysSequencePolicy selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysSequencePolicy record);

    int updateByPrimaryKey(SysSequencePolicy record);
    
    SysSequencePolicy selectByPolicyKey(String policyKey);
}