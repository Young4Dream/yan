package com.tstar.ocs.dao;

import java.util.List;
import java.util.Map;

import com.tstar.ocs.model.Cdr;

public interface CdrMapper {
    int deleteByPrimaryKey(String id);

    int insert(Cdr record);

    int insertSelective(Cdr record);

    Cdr selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Cdr record);

    int updateByPrimaryKey(Cdr record);
    
    int countAll();
    
    int countByCriteria(Map<String, Object> map);
    
    List<Cdr> selectByPage(Map<String, Object> map);
    
    List<Cdr> selectPricingByLogId(String logId, int status);
    
    int deleteByLogId(String logId);
    
    List<Cdr> selectByHashCode(String id, int hashCode);
    
    
}