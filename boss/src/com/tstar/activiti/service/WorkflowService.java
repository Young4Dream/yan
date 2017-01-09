package com.tstar.activiti.service;

import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import com.tstar.activiti.model.IBusinessEntity;

public interface WorkflowService {

	ProcessInstance start(IBusinessEntity entity, Map<String, Object> variables);
	
	List<Task> findTodoTasks(String userId);
	
	void convertToModel(String processDefinitionId) throws Exception;
	
}
