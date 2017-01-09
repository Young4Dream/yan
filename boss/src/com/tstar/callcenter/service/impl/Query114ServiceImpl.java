package com.tstar.callcenter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tstar.callcenter.dao.admin.AdminConfMapper;
import com.tstar.callcenter.dao.autogenerate.Query114UserMapper;
import com.tstar.callcenter.model.QueryNum;
import com.tstar.callcenter.model.autogenerate.Query114User;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.Query114Service;

@Service
public class Query114ServiceImpl implements Query114Service{

	private static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
	
	@Resource
	private AdminConfMapper adminConfMapper;
	
	@Resource
	private Query114UserMapper uery114UserMapper;
	
	public List<ResultMap> query114List(Query114User query114User,int start,int length) {
		// TODO Auto-generated method stub
		ResultMap paraMap = new ResultMap();
		if(query114User!=null){
			paraMap.put("phone", query114User.getPhone());
			paraMap.put("index1", query114User.getIndex1());
			paraMap.put("index2", query114User.getIndex2());
			paraMap.put("index3", query114User.getIndex3());
			paraMap.put("index4", query114User.getIndex4());
			paraMap.put("index5", query114User.getIndex5());
			paraMap.put("index6", query114User.getIndex6());
			paraMap.put("code", query114User.getCode());
		}
	
		PageHelper.startPage(start/length+1, length);
		return adminConfMapper.select114ByPage(paraMap);
	}
	
	
	public int selectAll114Count(Query114User query114User){
		ResultMap paraMap = new ResultMap();
		if(query114User!=null){
			paraMap.put("phone", query114User.getPhone());
			paraMap.put("index1", query114User.getIndex1());
			paraMap.put("index2", query114User.getIndex2());
			paraMap.put("index3", query114User.getIndex3());
			paraMap.put("index4", query114User.getIndex4());
			paraMap.put("index5", query114User.getIndex5());
			paraMap.put("index6", query114User.getIndex6());
			paraMap.put("code", query114User.getCode());
		}
		return adminConfMapper.select114ByCount(paraMap);
	}
	
	//114查号表插入记录
    public int queryNumInsert(QueryNum queryNum) {
        //phoneTrouble.setDate(new Date());
        int i = 0;
        	//query114UserMapper.queryNumInsert(queryNum);
        return i;
    }
	
    //114查号表更新记录
    public int queryNumUpdate(QueryNum queryNum) {
        //phoneTrouble.setDate(new Date());
        int i = 0;
        	//query114UserMapper.queryNumUpdate(queryNum);
        return i;
    }

    //114查号表删除记录
    public int queryNumDelete(QueryNum queryNum) {
        //phoneTrouble.setDate(new Date());
        int i = 0;
        	//query114UserMapper.queryNumDelete(queryNum);
        return i;
    }
}
