package com.tstar.callcenter.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.callcenter.model.QueryNum;
import com.tstar.callcenter.model.autogenerate.Query114User;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.Query114Service;

public class Query114Action extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Query114User query114User = new Query114User();
	private List<ResultMap> list114 = new ArrayList<ResultMap>();
	private String tel;
	private int recordsTotal;
	private int draw;
	private int recordsFiltered;
	private int start;
	private int length;
	private String res;
	private QueryNum queryNum;
	
	@Resource
	private Query114Service query114Service;
	
	
	public String goTo114Page(){
		
		return "numPage";
	}
	
	public String goToTelMgrPage(){
        
        return "telMgrPage";
    }	
	
	public String query114List(){
		list114 = query114Service.query114List(query114User, start, length);
		recordsTotal = query114Service.selectAll114Count(query114User);
		recordsFiltered = recordsTotal;
		return "numJson";
	}
	
	public String queryNumInsert(){
	    int i= 0;
        i = query114Service.queryNumInsert(queryNum);
        if(i == 0){
            setRes("受理成功");
        }else{
            setRes("受理失败");
        }
        return "queryNumInsert";
	}
	
	public String queryNumUpdate(){
        int i= 0;
        i = query114Service.queryNumUpdate(queryNum);
        if(i == 0){
            setRes("受理成功");
        }else{
            setRes("受理失败");
        }
        return "queryNumUpdate";
    }
	
	public String queryNumDelete(){
        int i= 0;
        i = query114Service.queryNumDelete(queryNum);
        if(i > 0){
            setRes("受理成功");
        }else{
            setRes("受理失败");
        }
        return "queryNumDelete";
    }
	


	public Query114User getQuery114User() {
		return query114User;
	}

	public void setQuery114User(Query114User query114User) {
		this.query114User = query114User;
	}

	public List<ResultMap> getList114() {
		return list114;
	}

	public void setList114(List<ResultMap> list114) {
		this.list114 = list114;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public QueryNum getQueryNum() {
        return queryNum;
    }

    public void setQueryNum(QueryNum queryNum) {
        this.queryNum = queryNum;
    }
	
	
	
	
	


	
	
	
	
	

}
