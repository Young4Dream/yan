package com.tstar.callcenter.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.callcenter.model.InsertTrouble;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.TroubleAcceptService;


public class TroubleAcceptAction extends ActionSupport {

	/**
	 */
	private static final long serialVersionUID = 1L;

	private int recordsTotal;
	private int draw;
	private int recordsFiltered;
	private int start;
	private int length;
	private String res;
	private String resNum;
	private String dh;
    private String account;
	
	private String jobtype;//故障类型
	private String thiskey;//故障号码
	private String queryType;//查询哪个字段，1用户号码，2用户名称，3用户地址
	private String moreField;//是否多字段查询，1多字段，0单字段
	private String exact;//是否精确查询，1精确查询，0模糊查询
	private String v_jobid;//工单编号 查询流程
	private String orderType;//工单类型：电话、宽带、故障
	private InsertTrouble insertTrouble;//故障受理
	private List<ResultMap> userInfo= new ArrayList<ResultMap>();//112查询用户信息
	private List<ResultMap> trouType= new ArrayList<ResultMap>();//查询故障类型信息
	private List<ResultMap> trouHist= new ArrayList<ResultMap>();//查询用户历史受理信息
	private List<ResultMap> workFlow= new ArrayList<ResultMap>();//查询工单流转信息
	
	ResultMap resultMap = new ResultMap();

	@Resource
	TroubleAcceptService troubleAcceptService ;
	
	public String goToTrouPage(){
		return "trouPage";
	}
	
	//112查询用户信息
	public String userInfoList(){
		userInfo = troubleAcceptService.findTrouUser(jobtype, thiskey, queryType, moreField, exact, start, length);
		recordsTotal = troubleAcceptService.getTrouUserCount();
        recordsFiltered = recordsTotal;
		return "userInfoList";
	}
	//查询故障类型信息
	public String trouTypeList(){
		trouType = troubleAcceptService.findTrouType(jobtype);
		return "trouTypeList";
	}
	//查询用户历史受理信息
	public String trouHistList() throws IOException{
		trouHist = troubleAcceptService.findTrouHist(jobtype, thiskey);
		return "trouHistList";
	}
	//查询工单流转信息
	public String workFlowList(){
	    int end = start + length;
	    String queryStr = "OrderType=" + orderType + ";OrderId=" + v_jobid + ";Start=" + start + ";End=" + end + ";";
		workFlow = troubleAcceptService.findworkFlow(queryStr);
		return "workFlowList";
	}
	
	//故障受理
	public String insertTrouble(){
		String[] r = troubleAcceptService.insertTrouble(insertTrouble);
		resNum = r[0];
		res = r[1];
		return "insertTrouble";
	}
	
	//故障受理时校验电话
	public String checkDh(){
        resultMap = troubleAcceptService.checkDh(dh);
        return "checkDh";
    }
    
	//故障受理时校验宽带账号
    public String checkBroad(){
        resultMap = troubleAcceptService.checkBroad(account);
        return "checkBroad";
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

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public String getThiskey() {
		return thiskey;
	}

	public void setThiskey(String thiskey) {
		this.thiskey = thiskey;
	}

	public String getV_jobid() {
		return v_jobid;
	}

	public void setV_jobid(String vJobid) {
		v_jobid = vJobid;
	}

	public InsertTrouble getInsertTrouble() {
		return insertTrouble;
	}

	public void setInsertTrouble(InsertTrouble insertTrouble) {
		this.insertTrouble = insertTrouble;
	}

	public List<ResultMap> getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(List<ResultMap> userInfo) {
		this.userInfo = userInfo;
	}

	public List<ResultMap> getTrouType() {
		return trouType;
	}

	public void setTrouType(List<ResultMap> trouType) {
		this.trouType = trouType;
	}

	public List<ResultMap> getTrouHist() {
		return trouHist;
	}

	public void setTrouHist(List<ResultMap> trouHist) {
		this.trouHist = trouHist;
	}

	public List<ResultMap> getWorkFlow() {
		return workFlow;
	}

	public void setWorkFlow(List<ResultMap> workFlow) {
		this.workFlow = workFlow;
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

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getMoreField() {
        return moreField;
    }

    public void setMoreField(String moreField) {
        this.moreField = moreField;
    }

    public String getExact() {
        return exact;
    }

    public void setExact(String exact) {
        this.exact = exact;
    }

    public ResultMap getResultMap() {
        return resultMap;
    }

    public void setResultMap(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }


    
	
	
	
	
	

}
