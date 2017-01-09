package com.tstar.crm.dao;

import java.math.BigDecimal;

import com.tstar.crm.model.CrmAccount;

public interface CrmAccountMapper {
    int deleteByPrimaryKey(String id);

    int insert(CrmAccount record);

    int insertSelective(CrmAccount record);

    CrmAccount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CrmAccount record);

    int updateByPrimaryKey(CrmAccount record);
    
    CrmAccount selectByCustomerId(String customerId);
    
    int addAmount(String accountId, BigDecimal amount);
    
    int addScore(String accountId, BigDecimal score);
}