package com.tstar.crm.dao;

import java.util.List;
import java.util.Map;

import com.tstar.crm.model.CrmOrder;

public interface CrmOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(CrmOrder record);

    int insertSelective(CrmOrder record);

    CrmOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CrmOrder record);

    int updateByPrimaryKey(CrmOrder record);
    
    int countByCriteria(Map<String, Object> criteria);
    
    List<CrmOrder> selectByPage(Map<String, Object> criteria);
    
    List<Map<String, Object>> selectPlanInOrder(String customerId, String businessKey);
    
    List<Map<String, Object>> selectProductInOrder(String customerId, String businessKey);
    
    List<Map<String, Object>> selectFeeInOrder(String customerId, String businessKey);
    
    List<Map<String, Object>> selectPlanInOrderByUser(String userId);
    
    List<Map<String, Object>> selectProductInOrderByUser(String userId);
    
    List<Map<String, Object>> selectFeeInOrderByUser(String userId);
    
}