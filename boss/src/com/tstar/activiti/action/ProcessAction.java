package com.tstar.activiti.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.activiti.service.WorkflowService;
import com.tstar.util.ExceptionUtil;

public class ProcessAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
    @Autowired
    RepositoryService repositoryService;
    
    @Resource
    WorkflowService workflowService;
	
	private String id;
	private List<Map<String, Object>> lst;
	private String userId;
	
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setLst(List<Map<String, Object>> lst) { this.lst = lst; }
	public List<Map<String, Object>> getLst() { return lst; }
	
	public void setUserId(String userId) { this.userId = userId; }
	public String getUserId() { return userId; }
	
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
	
	public String goToProcessPage() {
		return "showProcessPage";
	}
	
	public String goToTaskPage() {
		return "showTaskPage";
	}
	
	public String findAll() {
		ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery().orderByDeploymentId().desc();
		List<ProcessDefinition> processDefinitionList = processDefinitionQuery.list();
		lst = new ArrayList<Map<String, Object>>();
        for (ProcessDefinition processDefinition : processDefinitionList) {
            String deploymentId = processDefinition.getDeploymentId();
            System.out.println("deploymentId=" + deploymentId + ", modelId=" + processDefinition.getId());
            if (deploymentId != null && !"".equals(deploymentId)) {
            	Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(deploymentId).singleResult();
            	Map<String, Object> map = new HashMap<String, Object>();
            	map.put("id", deployment.getId());
            	map.put("name", deployment.getName());
            	map.put("deploymentTime", deployment.getDeploymentTime());
            	map.put("processDefinitionId", processDefinition.getId());
            	lst.add(map);
            }
            System.out.println("lst.size=" + lst.size());
        }
		
		recordsTotal = lst.size();
		recordsFiltered = recordsTotal;
		return "getRecords";
	}
	
	public String findTodoTasks() {
		List<Task> taskList = workflowService.findTodoTasks(userId);
		lst = new ArrayList<Map<String, Object>>();
		for (Task task : taskList) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", task.getId());
			map.put("name", task.getName());
			map.put("assignee", task.getAssignee());
			map.put("processDefinitionId", task.getProcessDefinitionId());
			map.put("processInstanceId", task.getProcessInstanceId());
			lst.add(map);
		}
		return "getRecords";
	}
	
	public String delete() {
		repositoryService.deleteDeployment(id, true);
        resNum = "0";
        res = "模型已成功删除";
        return "getRecords";
	}
	
	public String convertToModel() {
		try {
			workflowService.convertToModel(id);
			resNum = "0";
			res = "转化成功";
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
			resNum = "1";
			res = "转化失败:" + e.getMessage();
		}
		return "getRecords";
	}
	
}
