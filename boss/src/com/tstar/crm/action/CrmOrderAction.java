/**
 * 
 */
package com.tstar.crm.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.crm.model.CrmOrder;
import com.tstar.crm.model.CrmOrderItem;
import com.tstar.crm.model.CrmUser;
import com.tstar.crm.model.CrmUserAdsl;
import com.tstar.crm.model.CrmUserBroad;
import com.tstar.crm.model.CrmUserPhone;
import com.tstar.crm.model.CrmUserPl;
import com.tstar.crm.service.CrmOrderService;
import com.tstar.util.BeanHelper;
import com.tstar.util.ExceptionUtil;

/**
 * @author zhumengfeng
 *
 */
public class CrmOrderAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private CrmOrderService service;
	
	private String id;
	private CrmOrder obj;
	private List<CrmOrder> lst;
	private List<Map<String, Object>> maps;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(CrmOrder obj) { this.obj = obj; }
	public CrmOrder getObj() { return obj; }
	
	public void setLst(List<CrmOrder> lst) { this.lst = lst; }
	public List<CrmOrder> getLst() { return lst; }
	
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
	
	public String findByPage() {
		Map<String, Object> map = new HashMap<String, Object>();
		recordsTotal = service.countByCriteria(map);
		recordsFiltered = recordsTotal;
		map.put("start", start);
		map.put("length", length);
		lst = service.selectByPage(map);
		return "getRecords";
	}
	
	public String insert() {
		// 组装USER信息
		CrmUser u = new CrmUser();
		try { BeanHelper.setProperties(u, user); } catch (Exception e) {}
		obj.setUser(u);
		// 封装扩展USER信息
		String businessType = u.getBusinessType();
		if ("p".equals(businessType)) {
			u.setRelTable("crm_user_phone");
			CrmUserPhone phoneUser = new CrmUserPhone();
			try { BeanHelper.setProperties(phoneUser, user); } catch (Exception e) {}
			obj.setExtendedUser(phoneUser);
		} else if ("b".equals(businessType)) {
			u.setRelTable("crm_user_broad");
			CrmUserBroad broadUser = new CrmUserBroad();
			try { BeanHelper.setProperties(broadUser, user); } catch (Exception e) {
				System.out.println(ExceptionUtil.getStackTrace(e));
			}
			obj.setExtendedUser(broadUser);
		} else if ("a".equals(businessType)) {
			u.setRelTable("crm_user_adsl");
			CrmUserAdsl adslUser = new CrmUserAdsl();
			try { BeanHelper.setProperties(adslUser, user); } catch (Exception e) {}
			obj.setExtendedUser(adslUser);
		} else if ("l".equals(businessType)) {
			u.setRelTable("crm_user_pl");
			CrmUserPl plUser = new CrmUserPl();
			try { BeanHelper.setProperties(plUser, user); } catch (Exception e) {}
			obj.setExtendedUser(plUser);
		}
		// 订单项
		obj.setOrderItems(orderItems);
		
		try {
			String[] r = service.insert(obj);
			resNum = r[0];
			if ("0".equals(resNum)) {
				res = "装机成功";
				if ("0".equals(resNum) && 1 == obj.getPrintFlag()) {
					id = r[1];
				}
			} else {
				res = r[1];
			}
		} catch (Exception e) {
			resNum = "1";
			res = "装机失败：" + e.getMessage();
		}
		return "getRecords";
	}
	
	public String deleteUser() {
		// 添加拆机费用
		obj.setOrderItems(orderItems);
		try {
			String[] r = service.deleteUser(obj);
			resNum = r[0];
			res = "拆机工单已成功提交";
			if ("0".equals(resNum) && 1 == obj.getPrintFlag()) {
				id = r[1];
			}
		} catch (Exception e) {
			resNum = "1";
			res = "拆机失败：" + e.getMessage();
		}
		return "getRecords";
	}
	
	public String deleteUserImmediately() {
		String[] r = service.deleteUserImmediately(id);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	public String editUser() {
		// 组装USER信息
		CrmUser u = new CrmUser();
		try { BeanHelper.setProperties(u, user); } catch (Exception e) {}
		obj.setUser(u);
		// 封装扩展USER信息
		String businessType = u.getBusinessType();
		if ("p".equals(businessType)) {
			CrmUserPhone phoneUser = new CrmUserPhone();
			try { BeanHelper.setProperties(phoneUser, user); } catch (Exception e) {}
			obj.setExtendedUser(phoneUser);
		} else if ("b".equals(businessType)) {
			CrmUserBroad broadUser = new CrmUserBroad();
			try { BeanHelper.setProperties(broadUser, user); } catch (Exception e) {
				System.out.println(ExceptionUtil.getStackTrace(e));
			}
			obj.setExtendedUser(broadUser);
		} else if ("a".equals(businessType)) {
			CrmUserAdsl adslUser = new CrmUserAdsl();
			try { BeanHelper.setProperties(adslUser, user); } catch (Exception e) {}
			obj.setExtendedUser(adslUser);
		} else if ("l".equals(businessType)) {
			CrmUserPl plUser = new CrmUserPl();
			try { BeanHelper.setProperties(plUser, user); } catch (Exception e) {}
			obj.setExtendedUser(plUser);
		}
		String[] r = service.editUser(obj);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	public String changeUser() {
		obj.setOrderItems(orderItems);
		try {
			String[] r = service.changeUser(obj);
			resNum = r[0];
			res = "业务变更工单已成功提交";
			if ("0".equals(resNum) && 1 == obj.getPrintFlag()) {
				id = r[1];
			}
		} catch (Exception e) {
			resNum = "1";
			res = "业务变更失败：" + e.getMessage();
			System.out.println(ExceptionUtil.getStackTrace(e));
		}
		return "getRecords";
	}
	
	public String moveUser() {
		obj.setOrderItems(orderItems);
		try {
			String[] r = service.moveUser(obj);
			resNum = r[0];
			res = "移机工单已成功提交";
			if ("0".equals(resNum) && 1 == obj.getPrintFlag()) {
				id = r[1];
			}
		} catch (Exception e) {
			resNum = "1";
			res = "移机失败：" + e.getMessage();
		}
		return "getRecords";
	}
	
	public String transferUser() {
		obj.setOrderItems(orderItems);
		try {
			String[] r = service.transferUser(obj);
			resNum = r[0];
			res = "过户已成功保存";
			if ("0".equals(resNum) && 1 == obj.getPrintFlag()) {
				id = r[1];
			}
		} catch (Exception e) {
			resNum = "1";
			res = "过户失败：" + e.getMessage();
		}
		return "getRecords";
	}
	
	public String adjustUser() {
		try {
			String[] r = service.adjustUser(obj);
			resNum = r[0];
			res = r[1];
		} catch (Exception e) {
			resNum = "1";
			res = "调级失败：" + e.getMessage();
		}
		return "getRecords";
	}
	
	public String resetUser() {
		try {
			String[] r = service.resetUser(obj);
			resNum = r[0];
			res = r[1];
		} catch (Exception e) {
			resNum = "1";
			res = "调级失败：" + e.getMessage();
		}
		return "getRecords";
	}
	
	public String update() {
		String[] r = service.update(obj);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	public String delete() {
		String[] r = service.delete(id);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	private Map<String, String> user;

	public Map<String, String> getUser() {
		return user;
	}
	public void setUser(Map<String, String> user) {
		this.user = user;
	}
	
	private List<CrmOrderItem> orderItems;

	public List<CrmOrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<CrmOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public List<Map<String, Object>> getMaps() {
		return maps;
	}
	public void setMaps(List<Map<String, Object>> maps) {
		this.maps = maps;
	}
	
	public String selectPlanInOrder() {
		maps = service.selectPlanInOrder(obj.getCustomerId(), obj.getBusinessKey());
		return "getRecords";
	}
	
	public String selectProductInOrder() {
		maps = service.selectProductInOrder(obj.getCustomerId(), obj.getBusinessKey());
		return "getRecords";
	}
	
	public String selectFeeInOrder() {
		maps = service.selectFeeInOrder(obj.getCustomerId(), obj.getBusinessKey());
		return "getRecords";
	}
	
	public String findPlanInOrder() {
		maps = service.selectPlanInOrderByUser(obj.getId());
		return "getRecords";
	}
	
	public String findProductInOrder() {
		maps = service.selectProductInOrderByUser(obj.getId());
		return "getRecords";
	}
	
	public String findFeeInOrder() {
		maps = service.selectFeeInOrderByUser(obj.getId());
		return "getRecords";
	}
	
}
