package com.tstar.callcenter.service;

import java.util.List;

import com.tstar.callcenter.model.autogenerate.Knowledge;
import com.tstar.callcenter.model.autogenerate.KnowledgeClass;
import com.tstar.callcenter.model.autogenerate.KnowledgeQuestion;
import com.tstar.callcenter.pub.data.ResultMap;

public interface KnowledgeService {
	
	String[] insertKnowledgeClass(KnowledgeClass knowledgeClass);
	List<ResultMap> selectAllKnowClass();
	List<ResultMap> getKnowClassListByPage(KnowledgeClass knowledgeClass, int start, int length);
	int getKnowClassTotal(KnowledgeClass knowledgeClass);
	String[] updateKnowledgeClass(KnowledgeClass knowledgeClass);
	List<ResultMap> getKnowListByPage(Knowledge knowledge, int start, int length);
	String[] insertKnowledge(Knowledge knowledge);
	Knowledge selectKnowledgeById(Long klId);
	String[] updateKnowledge(Knowledge knowledge);
	String[] deleteknowledge(Long klId);
	List<ResultMap> searchKnowledge(Knowledge knowledge);
	int getKnowTotal(Knowledge knowledge);
	String[] deleteKnowledgeClass(Long klcId);
	String[] insertQuestionKnowledge(KnowledgeQuestion knowledgeQuestion);
	List<ResultMap> getQuestionListByPage(int start, int length);
	int getQuestionTotal();
	String[] delQuestionKnowledge(Long id);
}
