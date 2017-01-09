/**
 * 
 */
package com.tstar.crm.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.crm.model.OcsBillItem;
import com.tstar.crm.model.OcsInvoice;
import com.tstar.crm.model.OcsInvoiceItem;
import com.tstar.crm.service.OcsInvoiceService;
import com.tstar.util.BeanHelper;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
public class OcsInvoiceAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private OcsInvoiceService service;
	
	private String id;
	private Map<String, String> obj;
	private List<Map<String, Object>> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(Map<String, String> obj) { this.obj = obj; }
	public Map<String, String> getObj() { return obj; }
	
	public void setLst(List<Map<String, Object>> lst) { this.lst = lst; }
	public List<Map<String, Object>> getLst() { return lst; }
	
	public void setResNum(String resNum) { this.resNum = resNum; }
	public String getResNum() { return resNum; }
	
	public void setRes(String res) { this.res = res; }
	public String getRes() { return res; }
	
	// DataTable分页需要
	public int getRecordsTotal() { return recordsTotal; }
	public int getRecordsFiltered() { return recordsFiltered; }
	public int getStart() { return start; }
	public void setStart(int start) { this.start = start; }
	public int getLength() { return length; }
	public void setLength(int length) { this.length = length; }
	
	public String goToPage() {
		return "showHomePage";
	}
	
	public String goToNewPage() {
		return "showNewPage";
	}
	
	public String findByPage() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj != null) {
			if (!StringUtil.isEmpty(obj.get("invoiceNo"))) {
				map.put("invoiceNo", obj.get("invoiceNo"));
			}
			if (!StringUtil.isEmpty(obj.get("status"))) {
				map.put("status", Integer.parseInt(obj.get("status")));
			}
			if (!StringUtil.isEmpty(obj.get("invoiceType"))) {
				map.put("invoiceType", obj.get("invoiceType"));
			}
			if (!StringUtil.isEmpty(obj.get("customerNo"))) {
				map.put("customerNo", obj.get("customerNo"));
			}
			if (!StringUtil.isEmpty(obj.get("fullText"))) {
				map.put("fullText", obj.get("fullText"));
			}
		}
		recordsTotal = service.countByCriteria(map);
		recordsFiltered = recordsTotal;
		map.put("start", start);
		map.put("length", length);
		lst = new ArrayList<Map<String, Object>>();
		List<OcsInvoice> invoices = service.findByPage(map);
		if (invoices != null && invoices.size() > 0) {
			for (OcsInvoice item : invoices) {
				Map<String, Object> invoice = new HashMap<String, Object>();
				try { BeanHelper.bean2map(item, invoice); } catch (Exception e) {}
				lst.add(invoice);
			}
		}
		return "getRecords";
	}
	
	public String findItemsByInvoiceId() {
		lst = new ArrayList<Map<String, Object>>();
		List<OcsInvoiceItem> items = service.findItemsByInvoiceId(id);
		if (items != null && items.size() > 0) {
			for (OcsInvoiceItem item : items) {
				Map<String, Object> map = new HashMap<String, Object>();
				try { BeanHelper.bean2map(item, map); } catch (Exception e) {}
				lst.add(map);
			}
		}
		return "getRecords";
	}
	
	public String cancel() {
		String[] r = service.cancel(id);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
}
