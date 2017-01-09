package com.tstar.crm.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tstar.crm.model.OcsBill;

public interface OcsBillMapper {
    int deleteByPrimaryKey(String id);

    int insert(OcsBill record);

    int insertSelective(OcsBill record);

    OcsBill selectByPrimaryKey(String id);
    
    List<Map<String, Object>> selectAnother(String customerId, String id);
    
    OcsBill selectCustomerTopBill(String customerId);

    int updateByPrimaryKeySelective(OcsBill record);

    int updateByPrimaryKey(OcsBill record);
    
    OcsBill selectByUserIdAndDate(String userId, Date dt);
    
    int countByCriteria(Map<String, Object> map);
    
    List<Map<String, Object>> selectByPage(Map<String, Object> map);
    
    int updateStatusByBillNo(String billMonth, Integer status);
    
    int updateStatusByUserId(String userId, Integer status);
    
    int addAmount(String billId, BigDecimal amount);
    
    int addAmountProceed(String billId, BigDecimal amount);
    
    int updateStatus(String id, Integer status);
    
    List<Map<String, Object>> selectItemsByCustomer(Map<String, String> map);
    
    int updateStatusByCriteria(Map<String, Object> map);
    
    int finishByAmount(String billNo);
    
}