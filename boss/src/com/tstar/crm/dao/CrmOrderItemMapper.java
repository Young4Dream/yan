package com.tstar.crm.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tstar.crm.model.CrmOrderItem;

public interface CrmOrderItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(CrmOrderItem record);

    int insertSelective(CrmOrderItem record);

    CrmOrderItem selectByPrimaryKey(String id);
    
    List<CrmOrderItem> selectByOrderId(String orderId);

    int updateByPrimaryKeySelective(CrmOrderItem record);

    int updateByPrimaryKey(CrmOrderItem record);
    
    int makeEffective(String orderId, Date effectiveTime);
    
    int deleteByOrderId(String orderId);
    
    List<String> selectTopBillingItem(Map<String, Object> map);
}