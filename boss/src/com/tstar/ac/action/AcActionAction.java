/**
 * 
 */
package com.tstar.ac.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringEscapeUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.ac.model.AcAction;
import com.tstar.ac.model.AcCommand;
import com.tstar.ac.service.AcActionService;
import com.tstar.util.BeanHelper;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
public class AcActionAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private AcActionService service;
	
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
	
	public String findByPage() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj != null) {
			if (!StringUtil.isEmpty(obj.get("status"))) {
				map.put("status", obj.get("status"));
			}
			if (!StringUtil.isEmpty(obj.get("ossKey"))) {
				map.put("ossKey", obj.get("ossKey"));
			}
			if (!StringUtil.isEmpty(obj.get("businessKey"))) {
				map.put("businessKey", Integer.parseInt(obj.get("businessKey")));
			}
			if (!StringUtil.isEmpty(obj.get("businessType"))) {
				map.put("businessType", obj.get("businessType"));
			}
		}
		recordsTotal = service.countByCriteria(map);
		recordsFiltered = recordsTotal;
		map.put("start", start);
		map.put("length", length);
		lst = new ArrayList<Map<String, Object>>();
		List<AcAction> items = service.selectByPage(map);
		if (items != null && items.size() > 0) {
			for (AcAction item : items) {
				Map<String, Object> mapAction = new HashMap<String, Object>();
				try { BeanHelper.bean2map(item, mapAction); } catch (Exception e) {}
				lst.add(mapAction);
			}
		}
		return "getRecords";
	}
	
	public String findCmdsByActId() {
		lst = new ArrayList<Map<String, Object>>();
		List<AcCommand> items = service.selectCmdsByActId(id);
		if (items != null && items.size() > 0) {
			for (AcCommand item : items) {
				Map<String, Object> map = new HashMap<String, Object>();
				try { BeanHelper.bean2map(item, map); } catch (Exception e) {}
				// Cmd内容为xml格式的需要进行转义
				String cmd = (String)map.get("cmd");
				if (!StringUtil.isEmpty(cmd) && cmd.startsWith("<")) {
					map.put("cmd", StringEscapeUtils.escapeHtml4(cmd)); 
				}
				lst.add(map);
			}
		}
		return "getRecords";
	}
	
	// 重置Action，使之重新生成指令和执行
	public String reset() {
		String[] r = service.reset(id);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
		
}
