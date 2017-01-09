package com.tstar.portal.dao;

import com.tstar.portal.model.SysSequencePool;

public interface SysSequencePoolMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysSequencePool record);

    int insertSelective(SysSequencePool record);

    SysSequencePool selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysSequencePool record);

    int updateByPrimaryKey(SysSequencePool record);
    
    int unlock();
    
    int deleteByPolicyKeyAndValue(String policyKey, String seqValue);
    
    SysSequencePool selectTopOneByPolicyKey(String policyKey, String prefix);
 }