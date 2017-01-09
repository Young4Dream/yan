package com.tstar.crm.dao;

import java.util.List;

import com.tstar.crm.model.OcsInvoiceItem;

public interface OcsInvoiceItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(OcsInvoiceItem record);

    int insertSelective(OcsInvoiceItem record);

    OcsInvoiceItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OcsInvoiceItem record);

    int updateByPrimaryKey(OcsInvoiceItem record);
    
    List<OcsInvoiceItem> selectByForeignKey(String invoiceId);
}