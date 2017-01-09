/**
 * 
 */
package com.tstar.activiti.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.stereotype.Service;

import com.tstar.activiti.service.OpTaskService;
import com.tstar.crm.dao.JobOpInstanceMapper;
import com.tstar.crm.model.JobOpInstance;
import com.tstar.util.BeanHelper;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
@Service
public class OpTaskServiceImpl implements OpTaskService {

	@Resource
	private TaskService taskService;
	
	@Resource
	private RuntimeService runtimeService;
	
	@Resource
	private HistoryService historyService;
	
	@Resource
	private RepositoryService repositoryService;
	
	@Resource
	private FormService formService;
	
	@Resource
	private JobOpInstanceMapper daoJobOpInstance;
	
	public int countAll(String userId) {
		TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateOrAssigned(userId);
		return (int)taskQuery.count();
	}
	
	public int countRunning() {
		ProcessInstanceQuery processInstanceQuery = runtimeService.createProcessInstanceQuery();
		return (int)processInstanceQuery.count();
	}

	public List<Map<String, Object>> findByPage(String userId, int start,
			int length) {
		TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateOrAssigned(userId);
		List<Task> taskList = taskQuery.list();
		System.out.println("taskList.size()=" + taskList.size());
		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
		for (Task task : taskList) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", task.getId());
			map.put("name", task.getName());
			// assignee是任务签收人，为空则表示任务未被签收
			map.put("assignee", task.getAssignee());
			map.put("createTime", task.getCreateTime());
			// 到期时间
			map.put("dueDate", task.getDueDate());
			// 模型和流程实例数据
			map.put("processDefinitionId", task.getProcessDefinitionId());
			map.put("processInstanceId", task.getProcessInstanceId());
			// 业务数据
			ProcessInstance instance = runtimeService
				.createProcessInstanceQuery()
				.processInstanceId(task.getProcessInstanceId())
				.singleResult();
			map.put("businessKey", instance.getBusinessKey());
			if (!StringUtil.isEmpty(instance.getBusinessKey())) {
				JobOpInstance jobOpInstance = daoJobOpInstance.selectByPrimaryKey(instance.getBusinessKey());
				if (jobOpInstance != null) {
					try { BeanHelper.bean2map(jobOpInstance, map); } catch (Exception e) {}
				}
			}
			// 任务表单
			TaskFormData taskFormData = formService.getTaskFormData(task.getId());
			if (taskFormData != null) {
				map.put("formKey", taskFormData.getFormKey());
			}
			lst.add(map);
		}
		return lst;
	}
	
	public List<Map<String, Object>> getTaskFormProperties(String taskId) {
		TaskFormData taskFormData = formService.getTaskFormData(taskId);
		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
		if (taskFormData == null) return lst; 
		List<FormProperty> properties = taskFormData.getFormProperties();
		if (properties == null || properties.size() == 0) return lst;
		for (FormProperty property : properties) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", property.getId());
			map.put("name", property.getName());
			map.put("type", property.getType());
			map.put("isRequired", property.isRequired());
			map.put("isReadable", property.isReadable());
			map.put("isWritable", property.isWritable());
			if ("enum".equals(property.getType().getName())) {
				map.put("information", property.getType().getInformation("values")); 
			} else if ("date".equals(property.getType().getName())) {
				map.put("information", property.getType().getInformation("datePattern"));
			}
			Object value = taskService.getVariable(taskId, property.getId());
			if (value != null) {
				map.put("value", value);
			}
			lst.add(map);
		}
		return lst;
	}

	public String[] claim(Map<String, String> obj) {
		String taskId = obj.get("taskId");
		String userId = obj.get("userId");
		if (StringUtil.isEmpty(taskId) || StringUtil.isEmpty(userId)) {
			return new String[]{"1", "未知的错误：任务ID缺失或者未登录！"};
		}
		taskService.claim(taskId, userId);
		return new String[]{"0", "任务已签收，可以办理！"};
	}
	
	public String[] handle(String taskId, Map<String, String> obj) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			if (obj != null) {
				for (String key : obj.keySet()) {
					map.put(key, obj.get(key));
				}
			}
			taskService.complete(taskId, map);
			return new String[]{"0", "任务提交成功！"};
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
			return new String[]{"1", "任务提交失败：" + e.getMessage()};
		}
	}

	public List<Map<String, Object>> findRunningByPage(int start, int length) {
		ProcessInstanceQuery processInstanceQuery = runtimeService.createProcessInstanceQuery();
		List<ProcessInstance> instances = processInstanceQuery.listPage(start, length);
		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
		if (instances == null || instances.size() == 0) return lst;
		for (ProcessInstance instance : instances) {
			Task task = taskService.createTaskQuery().processInstanceId(instance.getProcessInstanceId()).singleResult();
			JobOpInstance jobOpInstance = daoJobOpInstance.selectByPrimaryKey(instance.getBusinessKey());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("processInstanceId", instance.getId());
			map.put("processDefinitionKey", instance.getProcessDefinitionKey());
			map.put("processDefinitionName", instance.getProcessDefinitionName());
			if (task != null) {
				map.put("taskId", task.getId());
				map.put("taskName", task.getName());
				map.put("taskStartTime", task.getCreateTime());
				map.put("assignee", task.getAssignee());
			}
			if (jobOpInstance != null) {
				try { BeanHelper.bean2map(jobOpInstance, map); } catch (Exception e) {}
			}
			lst.add(map);
		}
		return lst;
	}
	
	public List<Map<String, Object>> findFinishedByPage(int start, int length) {
		HistoricProcessInstanceQuery query = historyService.createHistoricProcessInstanceQuery().finished().orderByProcessInstanceEndTime().desc();
		List<HistoricProcessInstance> instances = query.listPage(start, length);
		List<Map<String, Object>> lst = new ArrayList<Map<String, Object>>();
		if (instances == null || instances.size() == 0) return lst;
		for (HistoricProcessInstance instance : instances) {
			Map<String, Object> map = new HashMap<String, Object>();
			ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(instance.getProcessDefinitionId()).singleResult();
			JobOpInstance jobOpInstance = daoJobOpInstance.selectByPrimaryKey(instance.getBusinessKey());
			map.put("processInstanceId", instance.getId());
			map.put("processDefinitionKey", processDefinition.getKey());
			map.put("processDefinitionName", processDefinition.getName());
			map.put("instanceEndTime", instance.getEndTime());
			if (jobOpInstance != null) {
				try { BeanHelper.bean2map(jobOpInstance, map); } catch (Exception e) {}
			}
			lst.add(map);
		}
		return lst;
	}
	
}
