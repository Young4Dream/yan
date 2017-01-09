/**
 * 
 */
package com.tstar.crm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.crm.dao.OcsInvoiceItemMapper;
import com.tstar.crm.dao.OcsInvoiceMapper;
import com.tstar.crm.model.OcsInvoice;
import com.tstar.crm.model.OcsInvoiceItem;
import com.tstar.crm.service.OcsInvoiceService;

/**
 * @author zhumengfeng
 *
 */
@Service
public class OcsInvoiceServiceImpl implements OcsInvoiceService {

	@Resource
	private OcsInvoiceMapper dao;
	@Resource
	private OcsInvoiceItemMapper daoOcsInvoiceItem;
	
	public int countByCriteria(Map<String, Object> map) {
		return dao.countByCriteria(map);
	}

	public List<OcsInvoice> findByPage(Map<String, Object> map) {
		return dao.selectByPage(map);
	}

	public OcsInvoice findByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<OcsInvoiceItem> findItemsByInvoiceId(String invoiceId) {
		return daoOcsInvoiceItem.selectByForeignKey(invoiceId);
	}
	
	public String[] cancel(String id) {
		int r = dao.updateStatus(id, 9);
		if (r > 0) {
			return new String[]{"0", "票据已取消"};
		} else {
			return new String[]{"1", "票据取消失败"};
		}
	}

}
