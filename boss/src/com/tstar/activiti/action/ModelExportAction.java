package com.tstar.activiti.action;

/**
 * Author: zhumengfeng
 * 导出模型文件，STRUTS2支持
 */
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.tstar.util.ExceptionUtil;

public class ModelExportAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
    @Autowired
    RepositoryService repositoryService;
	
	private String id;
	private String filename;
	private byte[] exportBytes;

	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setFilename(String filename) { this.filename = filename; }
	public String getFilename() { return filename; }
	
	public String export() {
        return "success";
	}
	
	public InputStream getDownloadFile() {
        try {
            Model modelData = repositoryService.getModel(id);
            BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
            byte[] modelEditorSource = repositoryService.getModelEditorSource(modelData.getId());

            JsonNode editorNode = new ObjectMapper().readTree(modelEditorSource);
            BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editorNode);

            // 处理异常
            if (bpmnModel.getMainProcess() == null) {
            	System.out.println("Missing main process.");
                return null;
            }

            filename = "";
            exportBytes = null;

            String mainProcessId = bpmnModel.getMainProcess().getId();

            BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
            exportBytes = xmlConverter.convertToXML(bpmnModel);

            filename = mainProcessId + ".bpmn20.xml";
            
            return new ByteArrayInputStream(exportBytes);

        } catch (Exception e) {
        	System.out.println(ExceptionUtil.getStackTrace(e));
        	return null;
        }
	}
	
}
