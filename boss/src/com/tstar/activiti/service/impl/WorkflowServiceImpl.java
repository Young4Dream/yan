package com.tstar.activiti.service.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tstar.activiti.model.IBusinessEntity;
import com.tstar.activiti.service.WorkflowService;

@Service
public class WorkflowServiceImpl implements WorkflowService {

	@Resource
	IdentityService identityService;
	
	@Resource
	RepositoryService repositoryService;
	
	@Resource
	RuntimeService runtimeService;
	
	@Resource
	HistoryService historyService;
	
	@Resource
	TaskService taskService;
	
	/**
	 * 启动流程
	 */
	public ProcessInstance start(IBusinessEntity entity, Map<String, Object> variables) {
		String businessKey = entity.getId();
		ProcessInstance processInstance = null;
		try {
			identityService.setAuthenticatedUserId(entity.getCreator());
			processInstance = runtimeService.startProcessInstanceByKey(entity.getProcessName(), businessKey, variables);
			entity.setProcessInstanceId(processInstance.getId());
		} finally {
			identityService.setAuthenticatedUserId(null);
		}
		return processInstance;
	}
	
	/**
	 * 查询待办任务
	 */
	public List<Task> findTodoTasks(String userId) {
		//List<Task> result = new ArrayList<Task>();
		TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateOrAssigned(userId);
		//List<Task> tasks = taskQuery.list();
		return taskQuery.list();
		/*
		for (Task task : tasks) {
			if (processName.equals(task.getProcessDefinitionId())) {
				result.add(task);
			}
		}
		return result;
		*/
	}
	
	/**
	 * 查询运行中的流程实例
	 * @param processName
	 * @return
	 */
	public List<ProcessInstance> findRunningProcessInstance(String processName) {
		ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery().processDefinitionKey(processName).active().orderByProcessInstanceId().desc();
		return query.list();
	}
	
	/**
	 * 查询已完成的流程实例
	 * @param processName
	 * @return
	 */
	public List<HistoricProcessInstance> findFinishedProcessInstance(String processName) {
		HistoricProcessInstanceQuery query = historyService.createHistoricProcessInstanceQuery().processDefinitionKey(processName).finished().orderByProcessInstanceEndTime().desc();
		return query.list();
	}
	
	public void convertToModel(String processDefinitionId) throws Exception {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
        	.processDefinitionId(processDefinitionId).singleResult();
        InputStream bpmnStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(),
        processDefinition.getResourceName());
        XMLInputFactory xif = XMLInputFactory.newInstance();
        InputStreamReader in = new InputStreamReader(bpmnStream, "UTF-8");
        XMLStreamReader xtr = xif.createXMLStreamReader(in);
        BpmnModel bpmnModel = new BpmnXMLConverter().convertToBpmnModel(xtr);

        BpmnJsonConverter converter = new BpmnJsonConverter();
        com.fasterxml.jackson.databind.node.ObjectNode modelNode = converter.convertToJson(bpmnModel);
        Model modelData = repositoryService.newModel();
        modelData.setKey(processDefinition.getKey());
        modelData.setName(processDefinition.getResourceName());
        modelData.setCategory(processDefinition.getDeploymentId());
        //org.apache.commons.lang3.StringUtils.isN

        ObjectNode modelObjectNode = new ObjectMapper().createObjectNode();
        modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, processDefinition.getName());
        modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
        modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, processDefinition.getDescription());
        modelData.setMetaInfo(modelObjectNode.toString());

        repositoryService.saveModel(modelData);

        repositoryService.addModelEditorSource(modelData.getId(), modelNode.toString().getBytes("utf-8"));
	}

}
