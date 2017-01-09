/**
 * 
 */
package com.tstar.activiti.action;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.util.ExceptionUtil;

/**
 * @author zhumengfeng
 * 导出流程实例运行图, Struts2支持
 */
public class ModelDiagramAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
    @Autowired
    RepositoryService repositoryService;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    ProcessEngine processEngine;
	
	private String id;
	private String filename;
	private InputStream inputStream;

	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setFilename(String filename) { this.filename = filename; }
	public String getFilename() { return filename; }

	public String readDiagram() {
		HttpServletRequest request= ServletActionContext.getRequest();
		id = request.getParameter("id");
		generateDiagram();
        return "success";
	}
	
	public InputStream generateDiagram() {
        try {
        	//查询流程实例
        	ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(id).singleResult();
        	BpmnModel bpmnModel = this.repositoryService.getBpmnModel(pi.getProcessDefinitionId());
        	//得到正在执行的环节
        	List<String> activeIds = runtimeService.getActiveActivityIds(pi.getId());
        	inputStream = new DefaultProcessDiagramGenerator().generateDiagram(
        			bpmnModel, "png",
        			activeIds, Collections.<String>emptyList(), 
        			processEngine.getProcessEngineConfiguration().getActivityFontName(), 
        			processEngine.getProcessEngineConfiguration().getLabelFontName(), 
        			null, 1.0);
        	filename = pi.getId() + ".png";
        	return inputStream;
        } catch (Exception e) {
        	System.out.println(ExceptionUtil.getStackTrace(e));
        	return null;
        }
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}
