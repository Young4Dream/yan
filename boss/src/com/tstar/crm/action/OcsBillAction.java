/**
 * 
 */
package com.tstar.crm.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tstar.crm.model.CrmAccount;
import com.tstar.crm.model.CrmUser;
import com.tstar.crm.model.Customer;
import com.tstar.crm.model.OcsBill;
import com.tstar.crm.model.OcsBillItem;
import com.tstar.crm.service.CrmAccountService;
import com.tstar.crm.service.CrmUserService;
import com.tstar.crm.service.CustomerService;
import com.tstar.crm.service.OcsBillService;
import com.tstar.util.BeanHelper;
import com.tstar.util.DateUtil;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
public class OcsBillAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private OcsBillService service;
	@Resource
	private CustomerService customerService;
	@Resource
	private CrmUserService userService;
	@Resource
	private CrmAccountService accountService;
	
	
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
	
	public String goToPayPage() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("billInfo");
		
		HttpServletRequest request= ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String customerId = request.getParameter("customerId");
		if (StringUtil.isEmpty(customerId) && StringUtil.isEmpty(id)) {
			return "showPayPage";
		}
		
		OcsBill bill = null;
		CrmUser user = null;
		Customer customer = null;
		CrmAccount account = null;
		// 根据客户号载入账单信息
		System.out.println("id=" + id);
		System.out.println("customerId=" + customerId);
		if (!StringUtil.isEmpty(customerId)) {
			customer = customerService.selectByPrimaryKey(customerId);
			bill = service.findCustomerTopBill(customerId);
			if (bill != null) {
				user = userService.selectByPrimaryKey(bill.getUserId());
				System.out.println(bill.getCreditorId());
				account = accountService.selectByPrimaryKey(bill.getCreditorId());
			} else {
				account = accountService.selectByCustomerId(customerId);
			}
		} else {
			bill = service.selectByPrimaryKey(id);
			user = userService.selectByPrimaryKey(bill.getUserId());
			customer = customerService.selectByPrimaryKey(user.getCustomerId());
			account = accountService.selectByPrimaryKey(bill.getCreditorId());
		}
		Map<String, Object> billMap = new HashMap<String, Object>();
		billMap.put("customer", customer);
		billMap.put("user", user);
		billMap.put("balance", "" + account.getAmount().doubleValue());
		billMap.put("score", "" + account.getScore().doubleValue());
		if (bill != null) {
			billMap.put("bill", bill);
			billMap.put("endDate", DateUtil.formatDate(bill.getEndDate()));
			billMap.put("amount", "" + (bill.getAmountDue().doubleValue() - bill.getAmountProceed().doubleValue()));
			double amountDue = bill.getAmountDue().doubleValue() - bill.getAmountProceed().doubleValue() - account.getAmount().doubleValue();
			if (amountDue < 0) { amountDue = 0; }
			billMap.put("amountDue", "" + amountDue);
		} else {
			billMap.put("amount", "0");
			billMap.put("amountDue", "0");
		}
		session.put("billInfo", billMap);
		
		return "showPayPage";
	}
	
	public String findByPage() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj != null) {
			if (!StringUtil.isEmpty(obj.get("billNo"))) {
				map.put("billNo", obj.get("billNo"));
			}
			if (!StringUtil.isEmpty(obj.get("fullText"))) {
				map.put("fullText", obj.get("fullText"));
			}
			if (!StringUtil.isEmpty(obj.get("status"))) {
				map.put("status", Integer.parseInt(obj.get("status")));
			}
			if (!StringUtil.isEmpty(obj.get("businessType"))) {
				map.put("businessType", obj.get("businessType"));
			}
		}
		recordsTotal = service.countByCriteria(map);
		recordsFiltered = recordsTotal;
		map.put("start", start);
		map.put("length", length);
		lst = service.selectByPage(map);
		return "getRecords";
	}
	
	public String findItemsByBillId() {
		lst = new ArrayList<Map<String, Object>>();
		List<OcsBillItem> items = service.selectItemsByBillId(id);
		if (items != null && items.size() > 0) {
			for (OcsBillItem item : items) {
				Map<String, Object> map = new HashMap<String, Object>();
				try { BeanHelper.bean2map(item, map); } catch (Exception e) {}
				lst.add(map);
			}
		}
		return "getRecords";
	}
	
	public String findAnotherBills() {
		lst = service.findAnotherBills(obj.get("customerId"), obj.get("id"));
		return "getRecords";
	}
	
	public String releaseBillByUserId() {
		String[] r = service.releaseUserBill(id);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	public String releaseBills() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj != null) {
			if (!StringUtil.isEmpty(obj.get("billNo"))) {
				map.put("billNo", obj.get("billNo"));
			}
			if (!StringUtil.isEmpty(obj.get("fullText"))) {
				map.put("fullText", obj.get("fullText"));
			}
			if (!StringUtil.isEmpty(obj.get("businessType"))) {
				map.put("businessType", obj.get("businessType"));
			}
		}
		String[] r = service.releaseBills(map); //id = billMonth
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	public String releaseBill() {
		String[] r = service.updateStatus(id, 2);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	public String badBill() {
		String[] r = service.updateStatus(id, 91);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	public String normalBill() {
		String[] r = service.updateStatus(id, 2);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	public String pay() {
		try {
			id = service.pay(obj);
			resNum = "0";
			res = "缴费成功";
		} catch (Exception e) {
			resNum = "1";
			res = "缴费失败:" + e.getMessage();
			System.out.println(ExceptionUtil.getStackTrace(e));
		}
		return "getRecords";
	}
	
	public String createInvoice() {
		try {
			id = service.createInvoice(obj);
			resNum = "0";
			res = "创建票据成功";
		} catch (Exception e) {
			resNum = "1";
			res = "创建票据失败:" + e.getMessage();
			System.out.println(ExceptionUtil.getStackTrace(e));
		}
		return "getRecords";
	}
	
	public String findItemsByCustomer() {
		lst = service.findItemsByCustomer(obj);
		return "getRecords";
	}
	
}
