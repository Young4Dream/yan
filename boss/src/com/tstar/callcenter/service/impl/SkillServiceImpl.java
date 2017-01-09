package com.tstar.callcenter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tstar.callcenter.dao.admin.AdminConfMapper;
import com.tstar.callcenter.dao.autogenerate.SkillGroupsMapper;
import com.tstar.callcenter.dao.autogenerate.SkillInfoMapper;
import com.tstar.callcenter.model.autogenerate.SkillInfo;
import com.tstar.callcenter.pub.data.ResultMap;

@Service
public class SkillServiceImpl {

	private static final Logger logger = Logger.getLogger(SkillServiceImpl.class);
	
	@Resource
	private SkillInfoMapper skillInfoMapper;
	@Resource
	private SkillGroupsMapper skillGroupsMapper;
	@Resource
	private AdminConfMapper adminConfMapper;
	
	//@Transactional(rollbackFor=Exception.class) 事物回滚，可用于多个insert，update，delete操作的时候
	public List<ResultMap> selectSkillList(SkillInfo skillInfo,int start,int length){
		ResultMap paraMap = new ResultMap();
		if(skillInfo!=null){
			paraMap.put("skill_code", skillInfo.getSkillCode());
			paraMap.put("skill_name", skillInfo.getSkillName());
		}
		paraMap.put("pageSize", length);
		paraMap.put("offset", start);

		return adminConfMapper.selectSkillByPage(paraMap);
	}
	
	public int selectAllSkillCount(SkillInfo skillInfo){
		ResultMap paraMap = new ResultMap();
		if(skillInfo!=null){
			paraMap.put("skill_code", skillInfo.getSkillCode());
			paraMap.put("skill_name", skillInfo.getSkillName());
		}
		return adminConfMapper.selectSkillByCount(paraMap);
	}
	
	public String[] insertSkillInfo(SkillInfo skillInfo){
		String[] res = {"",""};
		int result = skillInfoMapper.insertSelective(skillInfo);
		if(result>0){
			res[1]="添加成功!";
			res[0]="1";
		}else{
			res[1]="添加失败!";
			res[0]="0";			
		}
		return res;
	}
	
	public String[] updateSkillById(SkillInfo skillInfo){
		String[] res = {"",""};
		int result = skillInfoMapper.updateByPrimaryKeySelective(skillInfo);
		if(result>0){
			res[1]="更新成功!";
			res[0]="1";
		}else{
			res[1]="更新失败!";
			res[0]="0";			
		}
		return res;		
	}
	
	public String[] deleteSkillById(long id){
		String[] res = {"",""};
		int result = skillInfoMapper.deleteByPrimaryKey(id);
		if(result>0){
			res[1]="删除成功!";
			res[0]="1";
		}else{
			res[1]="删除失败!";
			res[0]="0";			
		}
		return res;	
	}
	
}
