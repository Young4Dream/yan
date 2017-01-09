package com.tstar.activiti.model;

public interface IBusinessEntity {
	String getId();
	void setId(String id);
	
	String getCreator();
	void setCreator(String creator);
	
	String getProcessName();
	void setProcessName(String processName);
	
	String getProcessInstanceId();
	void setProcessInstanceId(String processInstanceId);
}
