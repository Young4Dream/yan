package com.tstar.crm.dao;

import java.util.List;
import java.util.Map;

import com.tstar.crm.model.OcsInvoice;

public interface OcsInvoiceMapper {
    int deleteByPrimaryKey(String id);

    int insert(OcsInvoice record);

    int insertSelective(OcsInvoice record);

    OcsInvoice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OcsInvoice record);

    int updateByPrimaryKey(OcsInvoice record);

    int countByCriteria(Map<String, Object> map);
    
    List<OcsInvoice> selectByPage(Map<String, Object> map);
    
    int countByInvoiceNo(String invoiceNo);
    
    int updateStatus(String id, Integer status);
}