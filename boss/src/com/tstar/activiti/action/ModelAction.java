package com.tstar.activiti.action;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tstar.util.ExceptionUtil;

public class ModelAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
    @Autowired
    RepositoryService repositoryService;
	
	private String id;
	//private Model obj;
	private String name;
	private String key;
	private String description;
	private List<Model> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	//public void setObj(Model obj) { this.obj = obj; }
	//public Model getObj() { return obj; }
	
	public void setName(String name) { this.name = name; }
	public String getName() { return name; }
	
	public void setKey(String key) { this.key = key; }
	public String getKey() { return key; }
	
	public void setDescription(String description) { this.description = description; }
	public String getDescription() { return description; }
	
	public void setLst(List<Model> lst) { this.lst = lst; }
	public List<Model> getLst() { return lst; }
	
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
	
	public String goToModelPage() {
		return "showModelPage";
	}
	
	public String goToProcessPage() {
		return "showProcessPage";
	}
	
	public String findAll() {
		lst = repositoryService.createModelQuery().list();
		recordsTotal = lst.size();
		recordsFiltered = recordsTotal;
		return "getRecords";
	}
	
	/**
	 * 创建流程模型
	 * @return
	 */
	public String create() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode editorNode = objectMapper.createObjectNode();
            editorNode.put("id", "canvas");
            editorNode.put("resourceId", "canvas");
            ObjectNode stencilSetNode = objectMapper.createObjectNode();
            stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
            editorNode.put("stencilset", stencilSetNode);
            Model modelData = repositoryService.newModel();

            ObjectNode modelObjectNode = objectMapper.createObjectNode();
            modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, name);
            modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
            description = StringUtils.defaultString(description);
            modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
            modelData.setMetaInfo(modelObjectNode.toString());
            modelData.setName(name);
            modelData.setKey(StringUtils.defaultString(key));

            repositoryService.saveModel(modelData);
            repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));

            id = modelData.getId();
            resNum = "0";
            res = "";
        } catch (Exception e) {
        	resNum = "1";
        	res = "创建模型失败：" + e.getMessage();
        }
        return "getRecords";
	}
	
	/**
	 * 删除流程模型
	 * @return
	 */
	public String delete() {
        repositoryService.deleteModel(id);
        resNum = "0";
        res = "模型已成功删除";
        return "getRecords";
	}
	
	/**
	 * 部署流程
	 * @return
	 */
	public String deploy() {
        try {
        	
            Model modelData = repositoryService.getModel(id);
            ObjectNode modelNode = (ObjectNode) new ObjectMapper().readTree(repositoryService.getModelEditorSource(modelData.getId()));
            byte[] bpmnBytes = null;

            BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
            bpmnBytes = new BpmnXMLConverter().convertToXML(model);
            
            System.out.println(new String(bpmnBytes, "utf-8"));

            String processName = modelData.getName() + ".bpmn20.xml";
            // 非常重要：
            //	BpmnXMLConverter().convertToXML得到的是UTF-8编码的字节流
            //	转化为字符时要显性指定字符集
            repositoryService
            	.createDeployment()
            	.name(modelData.getName())
            	.addString(processName, new String(bpmnBytes, "utf-8")).deploy();
            
            resNum = "0";
            res = "模型已成功部署";
        } catch (Exception e) {
        	//Log.getLogger().error(ExceptionUtil.getStackTrace(e));
            resNum = "1";
            res = "部署失败： " + e.getMessage();
        }
        return "getRecords";
	}
	
	/**
	 * 导出模型
	 * 导出文件格式为.bmpn.xml
	 * @return
	 */
	public String export() {
        try {
            Model modelData = repositoryService.getModel(id);
            BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
            byte[] modelEditorSource = repositoryService.getModelEditorSource(modelData.getId());

            JsonNode editorNode = new ObjectMapper().readTree(modelEditorSource);
            BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editorNode);

            // 处理异常
            if (bpmnModel.getMainProcess() == null) {
                resNum = "0";
                res = "没有主流程，无法导出";
                return "getRecords";
            }

            String filename = "";
            byte[] exportBytes = null;

            String mainProcessId = bpmnModel.getMainProcess().getId();

            BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
            exportBytes = xmlConverter.convertToXML(bpmnModel);

            filename = mainProcessId + ".bpmn20.xml";
            
            ByteArrayInputStream in = new ByteArrayInputStream(exportBytes);
            HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
            IOUtils.copy(in, response.getOutputStream());

            resNum = "0";
            res = "模型已导出，导出文件为" + filename;
        } catch (Exception e) {
        	System.out.println(ExceptionUtil.getStackTrace(e));
            resNum = "2";
            res = "导出失败：" + e.getMessage();
        }
        return "getRecords";
	}
	
	/**
	 * 导入流程模型
	 * 导入文件格式为.bpmn.xml
	 * @return
	 */
	public String importModel() {
        resNum = "0";
        res = "模型已导入";
        return "getRecords";
	}
		
}
