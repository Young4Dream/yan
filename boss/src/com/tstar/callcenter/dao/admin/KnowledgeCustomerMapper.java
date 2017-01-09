package com.tstar.callcenter.dao.admin;

import java.util.List;

import com.tstar.callcenter.pub.data.ResultMap;

public interface KnowledgeCustomerMapper {
	List<ResultMap> selectAllKnowClass();
	List<ResultMap> getKnowClassListByPage(ResultMap paraMap);
	List<ResultMap> getKnowListByPage(ResultMap paraMap);
	List<ResultMap> getQuestionListByPage(ResultMap paraMap);
}
