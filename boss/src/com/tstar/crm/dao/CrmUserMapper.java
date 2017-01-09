package com.tstar.crm.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tstar.crm.model.CrmUser;

public interface CrmUserMapper {
	
    int deleteByPrimaryKey(String id);

    int insert(CrmUser record);

    int insertSelective(CrmUser record);

    CrmUser selectByPrimaryKey(String id);
    
    CrmUser selectByBusinessKey(String businessKey);

    int updateByPrimaryKeySelective(CrmUser record);

    int updateByPrimaryKey(CrmUser record);
    
    int countByCriteria(Map<String, Object> map);
    
    List<CrmUser> selectByPage(Map<String, Object> map);
    
    int countEffectiveByKey(String businessType, String businessKey);
    
    int updateStatus(String id, Integer status);
    
    CrmUser selectByTime(String businessType, String businessKey, Date dt);
    
}