package com.tstar.crm.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.tstar.crm.model.OcsBillItem;

public interface OcsBillItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(OcsBillItem record);

    int insertSelective(OcsBillItem record);

    OcsBillItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OcsBillItem record);

    int updateByPrimaryKey(OcsBillItem record);
    
    List<OcsBillItem> selectByBillId(String billId);
    
    OcsBillItem selectByBillIdAndAccountItemId(String billId, String accountItemId);
    
    int addAmount(String itemId, BigDecimal amount);
    
    int addAmountProceed(String itemId, BigDecimal amount);
    
    List<Map<String, Object>> selectPrepaid();
}