package com.tstar.callcenter.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.callcenter.model.autogenerate.RecordHistroy;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.RecordService;

public class RecordAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private List<ResultMap> recordList = new ArrayList<ResultMap>();
	private RecordHistroy recordHistroy = new RecordHistroy();
	
	private int recordsTotal;
	private int draw;
	private int recordsFiltered;
	private int start;
	private int length;
	
	private String startTime;
	private String endTime;
	
	@Resource
	private RecordService recordService;
	
	
	
	public String goToRecordPage(){
		return "recordPage";
	}
	
	public String selectRecordList(){
		recordList = recordService.selectRecordList(recordHistroy, startTime, endTime, start, length);
		recordsTotal = recordService.selectAllRecordCount(recordHistroy, startTime, endTime);
		recordsFiltered = recordsTotal;
		return "recordList";
	}

	
	

	public List<ResultMap> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<ResultMap> recordList) {
		this.recordList = recordList;
	}

	public RecordHistroy getRecordHistroy() {
		return recordHistroy;
	}

	public void setRecordHistroy(RecordHistroy recordHistroy) {
		this.recordHistroy = recordHistroy;
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

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
	

}
