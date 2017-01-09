package com.tstar.callcenter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tstar.callcenter.dao.admin.KnowledgeCustomerMapper;
import com.tstar.callcenter.dao.autogenerate.KnowledgeClassMapper;
import com.tstar.callcenter.dao.autogenerate.KnowledgeMapper;
import com.tstar.callcenter.dao.autogenerate.KnowledgeQuestionMapper;
import com.tstar.callcenter.model.autogenerate.Knowledge;
import com.tstar.callcenter.model.autogenerate.KnowledgeClass;
import com.tstar.callcenter.model.autogenerate.KnowledgeClassExample;
import com.tstar.callcenter.model.autogenerate.KnowledgeExample;
import com.tstar.callcenter.model.autogenerate.KnowledgeQuestion;
import com.tstar.callcenter.model.autogenerate.KnowledgeQuestionExample;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.KnowledgeService;
@Service
public class KnowledgeServiceImpl implements KnowledgeService {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(KnowledgeServiceImpl.class);
	@Resource
	private KnowledgeClassMapper knowledgeClassMapper;
	@Resource
	private KnowledgeCustomerMapper knowledgeCustomerMapper;
	@Resource
	private KnowledgeMapper knowledgeMapper;
	@Resource
	private KnowledgeQuestionMapper knowledgeQuestionMapper;
	@Transactional(rollbackFor=Exception.class) //事物回滚，可用于多个insert，update，delete操作的时候
	public String[] insertKnowledgeClass(KnowledgeClass knowledgeClass) {
		String[] res = {"",""};
		int result=0;
		result= knowledgeClassMapper.insertSelective(knowledgeClass);
		if(result>0){
			res[0]="1";
			res[1]="添加成功";
		}
		return res;
	}
	
	public List<ResultMap> selectAllKnowClass() {
		List<ResultMap> allKnowClass = knowledgeCustomerMapper.selectAllKnowClass();
		return allKnowClass;
	}


	public List<ResultMap> getKnowClassListByPage(KnowledgeClass knowledgeClass, int start, int length) {
		
		ResultMap paraMap = new ResultMap();
		List<ResultMap> knowClassList= knowledgeCustomerMapper.getKnowClassListByPage(paraMap);
		return knowClassList;
	}

	public int getKnowClassTotal(KnowledgeClass knowledgeClass) {
		KnowledgeClassExample example = new KnowledgeClassExample();  
		KnowledgeClassExample.Criteria criteria = example.createCriteria();
		criteria.andKlcIdIsNotNull();
		return knowledgeClassMapper.countByExample(example);
	}

	public String[] updateKnowledgeClass(KnowledgeClass knowledgeClass) {
		String[] res = {"",""};
		int result= knowledgeClassMapper.updateByPrimaryKeySelective(knowledgeClass);
		if(result>0){
			res[0]="1";
			res[1]="更新成功";
		}else{
			res[0]="0";
			res[1]="更新失败";
		}
		return res;
	}
	//删除某条知识种类
	public String[] deleteKnowledgeClass(Long klcId) {
		String res[]={"",""};
		//判断该知识种类是否有子类
		KnowledgeClassExample example = new KnowledgeClassExample();  
		KnowledgeClassExample.Criteria criteria = example.createCriteria();
		criteria.andKlcParentidEqualTo(klcId);
		List<KnowledgeClass> selectByExample = knowledgeClassMapper.selectByExample(example);
		if(selectByExample.size()!=0){
			res[0]="0";
			res[1]="删除失败，请先删除该类别下的所有子类！！！";
			return res;
		}
		//判断是否有属于该知识种类的知识
		KnowledgeExample know = new KnowledgeExample();  
		KnowledgeExample.Criteria knowCriteria = know.createCriteria();
		knowCriteria.andKlcIdEqualTo(klcId);
		List<Knowledge> knowByExample = knowledgeMapper.selectByExample(know);
		if(knowByExample.size()!=0){
			res[0]="0";
			res[1]="删除失败，请先删除该类别下的所有知识！！！";
			return res;
		}
		//执行删除
		int result= knowledgeClassMapper.deleteByPrimaryKey(klcId);
		if(result>0){
			res[0]="1";
			res[1]="删除成功";
		}else{
			res[0]="0";
			res[1]="删除失败";
		}
		return res;
	}
	public List<ResultMap> getKnowListByPage(Knowledge knowledge, int start,int length) {
		ResultMap paraMap = new ResultMap();
		if(knowledge!=null){
			paraMap.put("kl_title",knowledge.getKlTitle());
			paraMap.put("kl_cid",knowledge.getKlcId());
		}
		paraMap.put("start",start+1);
		paraMap.put("length",start+length);
		List<ResultMap> knowClassList= knowledgeCustomerMapper.getKnowListByPage(paraMap);
		return knowClassList;
		
	}

	public String[] insertKnowledge(Knowledge knowledge) {
		String[] res={"",""};
		int result= knowledgeMapper.insertSelective(knowledge);
		if(result>0){
			res[0]="1";
			res[1]="添加成功";
		}
		return res;
	}

	public Knowledge selectKnowledgeById(Long klId) {
		Knowledge knowledge = knowledgeMapper.selectByPrimaryKey(klId);
		return knowledge;
	}

	public String[] updateKnowledge(Knowledge knowledge) {
		String[] res = {"",""};
		int result= knowledgeMapper.updateByPrimaryKeySelective(knowledge);
		if(result>0){
			res[0]="1";
			res[1]="更新成功";
		}else{
			res[0]="0";
			res[1]="更新失败";
		}
		return res;
		
	}
//删除某条知识
	public String[] deleteknowledge(Long klId) {
		String[] res={"",""};
		int result = knowledgeMapper.deleteByPrimaryKey(klId);
		if(result>0){
			res[0]="1";
			res[1]="删除成功";
		}else{
			res[0]="0";
			res[1]="删除失败";
		}
		return res;
	}

	public List<ResultMap> searchKnowledge(Knowledge knowledge) {
		// TODO Auto-generated method stub
		return null;
	}
	//统计数据库中知识记录
	public int getKnowTotal(Knowledge knowledge) {
		KnowledgeExample example = new KnowledgeExample();  
		KnowledgeExample.Criteria criteria = example.createCriteria();
		if(knowledge!=null){
			
			if(knowledge.getKlcId()!=null){
				criteria.andKlcIdEqualTo(knowledge.getKlcId());
			}
			if(knowledge.getKlTitle()!=null && !knowledge.getKlTitle().equals("")){
				criteria.andKlTitleLike("%"+knowledge.getKlTitle()+"%");
			}
		}
		
		
		criteria.andKlIdIsNotNull();
		return knowledgeMapper.countByExample(example);
	}
//插入一条问题
	public String[] insertQuestionKnowledge(KnowledgeQuestion knowledgeQuestion) {
		String res[]={"",""};
		int result= knowledgeQuestionMapper.insertSelective(knowledgeQuestion);
		if(result>0){
			res[0]="1";
			res[1]="提交成功";
		}else{
			res[0]="0";
			res[1]="提交失败";
		}
		return res;
	}

	public List<ResultMap> getQuestionListByPage(int start, int length) {
		ResultMap paraMap = new ResultMap();
		paraMap.put("start",start+1);
		paraMap.put("length",start+length);
		List<ResultMap> questionList= knowledgeCustomerMapper.getQuestionListByPage(paraMap);
		return questionList;
	}
//得到提交问题总数
	public int getQuestionTotal() {
		KnowledgeQuestionExample example = new KnowledgeQuestionExample();  
		KnowledgeQuestionExample.Criteria criteria = example.createCriteria();		
		criteria.andIdIsNotNull();
		return knowledgeQuestionMapper.countByExample(example);
	}

	public String[] delQuestionKnowledge(Long id) {
		String res[]={"",""};
		int result = knowledgeQuestionMapper.deleteByPrimaryKey(id);
		if(result>0){
			res[0]="1";
			res[1]="提交成功";
		}else{
			res[0]="0";
			res[1]="提交失败";
		}
		return res;
	}
}
