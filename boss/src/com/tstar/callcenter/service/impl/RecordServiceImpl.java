package com.tstar.callcenter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tstar.callcenter.dao.admin.AdminConfMapper;
import com.tstar.callcenter.model.autogenerate.RecordHistroy;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService{

	@Resource
	private AdminConfMapper adminConfMapper;
	
	public List<ResultMap> selectRecordList(RecordHistroy recordHist,
			String startTime, String endTime, int start, int length) {
		ResultMap para = new ResultMap();
		if(recordHist != null){
			para.put("start_time", startTime);
			para.put("end_time", endTime);
			para.put("empl_no", recordHist.getEmplNo());
			para.put("empl_name", recordHist.getEmplName());
			para.put("customer_tel", recordHist.getCustomerTel());
		}
		PageHelper.startPage(start/length+1, length);
		return adminConfMapper.selectRecordByPage(para);
	}

	
	public int selectAllRecordCount(RecordHistroy recordHist, String startTime, String endTime) {
		ResultMap para = new ResultMap();
		if(recordHist != null){
			para.put("start_time", startTime);
			para.put("end_time", endTime);
			para.put("empl_no", recordHist.getEmplNo());
			para.put("empl_name", recordHist.getEmplName());
			para.put("customer_tel", recordHist.getCustomerTel());
		}
		return adminConfMapper.selectAllRecordCount(para);
	}

}
