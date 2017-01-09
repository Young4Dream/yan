package com.tstar.callcenter.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.callcenter.model.autogenerate.Knowledge;
import com.tstar.callcenter.model.autogenerate.KnowledgeClass;
import com.tstar.callcenter.model.autogenerate.KnowledgeQuestion;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.KnowledgeService;

public class KnowledgeAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String res;
	private String resNum;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	private int draw;
	
	
	private Knowledge knowledge=new Knowledge();
	private KnowledgeClass knowledgeClass=new KnowledgeClass();
	private List<ResultMap> selectKnowledgeClass=new ArrayList<ResultMap>();
	private List<ResultMap> tableKnowledgeClass=new ArrayList<ResultMap>();
	private List<ResultMap> tableKnowledge=new ArrayList<ResultMap>();
	private List<ResultMap> tableQuestion=new ArrayList<ResultMap>();
	private KnowledgeQuestion knowledgeQuestion=new KnowledgeQuestion();
	@Resource
	private KnowledgeService knowledgeService;
	public String showKnowledge(){
		return "showKnowledge";
	}
	public String insertKnowledgeClass(){
		String[] r=knowledgeService.insertKnowledgeClass(knowledgeClass);
		res=r[1];
		resNum=r[0];
		return "jsonKnow";
	}
	//为下拉列表绑定知识种类
	public String selectAllKnowClass(){
		selectKnowledgeClass=knowledgeService.selectAllKnowClass();
		return "jsonKnow";
	}
	//得到所有的知识种类
	public String getKnowClassListByPage(){
		tableKnowledgeClass=knowledgeService.getKnowClassListByPage(knowledgeClass,start, length);
		recordsTotal=knowledgeService.getKnowClassTotal(knowledgeClass);
		
		recordsFiltered=recordsTotal;
		return "jsonKnow";
	}
	//更新知识种类 Byid
	public String updateKnowledgeClass(){
		String[] r=knowledgeService.updateKnowledgeClass(knowledgeClass);
		res=r[1];
		resNum=r[0];
		return "jsonKnow";
	}
	//删除某个知识种类
	public String deleteknowledgeClass(){
		String[] r=knowledgeService.deleteKnowledgeClass(knowledgeClass.getKlcId());
		recordsTotal=knowledgeService.getKnowClassTotal(knowledgeClass);
		recordsFiltered=recordsTotal;
		res=r[1];
		resNum=r[0];
		return "jsonKnow";
	}
	//得到知识列表
	public String getKnowListByPage(){
		tableKnowledge=knowledgeService.getKnowListByPage(knowledge,start, length);
		recordsTotal=knowledgeService.getKnowTotal(knowledge);
		recordsFiltered=recordsTotal;
		return "jsonKnow";
	}
	//插入一条知识
	public String insertKnowledge(){
		String[] r=knowledgeService.insertKnowledge(knowledge);
		recordsTotal=knowledgeService.getKnowTotal(knowledge);
		recordsFiltered=recordsTotal;
		res=r[1];
		resNum=r[0];
		return "jsonKnow";
	}
	//查询某条知识记录
	public String selectKnowledgeById(){
		knowledge=knowledgeService.selectKnowledgeById(knowledge.getKlId());
		return "jsonKnow";
	} 
	//更新某条知识记录
	public String updateKnowledge(){
		String[]r= knowledgeService.updateKnowledge(knowledge);
		res=r[1];
		resNum=r[0];
		return "jsonKnow";
	}
	//删除某条知识
	public String deleteknowledge(){
		String[]r=knowledgeService.deleteknowledge(knowledge.getKlId());
		recordsTotal=knowledgeService.getKnowTotal(knowledge);
		recordsFiltered=recordsTotal;
		res=r[1];
		resNum=r[0];
		return "jsonKnow";
	}
	//查询知识
	public String searchKnowledge(){
		tableKnowledge=knowledgeService.searchKnowledge(knowledge);
		
		return "jsonKnow";
	}

	public String insertQuestionKnowledge(){
		String[] r=knowledgeService.insertQuestionKnowledge(knowledgeQuestion);
		recordsTotal=knowledgeService.getQuestionTotal();
		recordsFiltered=recordsTotal;
		res=r[1];
		resNum=r[0];
		return "jsonKnow";
	}
	public String getQuestionListByPage(){
		tableQuestion=knowledgeService.getQuestionListByPage(start, length);
		recordsTotal=knowledgeService.getQuestionTotal();
		recordsFiltered=recordsTotal;
		return "jsonKnow";
	}
	public String delQuestionKnowledge(){
		String r[]={"",""};
		r=knowledgeService.delQuestionKnowledge(knowledgeQuestion.getId());
		res=r[1];
		resNum=r[0];
		return "jsonKnow";
	}
	
	
	
	
	
	public List<ResultMap> getTableKnowledgeClass() {
		return tableKnowledgeClass;
	}
	public void setTableKnowledgeClass(List<ResultMap> tableKnowledgeClass) {
		this.tableKnowledgeClass = tableKnowledgeClass;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	public String getResNum() {
		return resNum;
	}
	public void setResNum(String resNum) {
		this.resNum = resNum;
	}
	public KnowledgeClass getKnowledgeClass() {
		return knowledgeClass;
	}
	public void setKnowledgeClass(KnowledgeClass knowledgeClass) {
		this.knowledgeClass = knowledgeClass;
	}
	public List<ResultMap> getSelectKnowledgeClass() {
		return selectKnowledgeClass;
	}
	public void setSelectKnowledgeClass(List<ResultMap> selectKnowledgeClass) {
		this.selectKnowledgeClass = selectKnowledgeClass;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public List<ResultMap> getTableKnowledge() {
		return tableKnowledge;
	}
	public void setTableKnowledge(List<ResultMap> tableKnowledge) {
		this.tableKnowledge = tableKnowledge;
	}
	public Knowledge getKnowledge() {
		return knowledge;
	}
	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}
	public KnowledgeQuestion getKnowledgeQuestion() {
		return knowledgeQuestion;
	}
	public void setKnowledgeQuestion(KnowledgeQuestion knowledgeQuestion) {
		this.knowledgeQuestion = knowledgeQuestion;
	}
	public List<ResultMap> getTableQuestion() {
		return tableQuestion;
	}
	public void setTableQuestion(List<ResultMap> tableQuestion) {
		this.tableQuestion = tableQuestion;
	}
	
}
