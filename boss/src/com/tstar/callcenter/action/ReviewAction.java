package com.tstar.callcenter.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.ReviewService;

public class ReviewAction extends ActionSupport {
    
    private static final long serialVersionUID = 1L;
    
    private int recordsTotal;
    private int draw;
    private int recordsFiltered;
    private int start;
    private int length;
    private String res;
    private String resNum;
    
    private String jobtype;//工单类型
    private String thiskey;//故障号码
    private String queryType;//查询哪个字段，1用户号码，2用户名称，3用户地址
    private String moreField;//是否多字段查询，1多字段，0单字段
    private String exact;//是否精确查询，1精确查询，0模糊查询
    
    private List<ResultMap> telJob= new ArrayList<ResultMap>();//电话工单
    private List<ResultMap> faultJob= new ArrayList<ResultMap>();//故障工单
    
    @Resource
    ReviewService reviewService;
    
    public String goToReviewPage(){
        return "reviewPage";
    }
    
    public String goToMonitorPage(){
        return "monitorPage";
    }
    
    public String getTelJobList(){
        int end = start + length;
        String queryStr = "JobType=" + jobtype + ";Value=" + thiskey + ";Start=" + start + ";End=" + end + ";";
        telJob = reviewService.getTelJobList(queryStr);
        recordsTotal = reviewService.getTelJobCount();
        recordsFiltered = recordsTotal;
        return "telJobList";
    }
    
    public String getFaultJobList(){
        int end = start + length;
        String queryStr = "JobType=" + jobtype + ";Value=" + thiskey + ";Start=" + start + ";End=" + end + ";";
        faultJob = reviewService.getFaultJobList(queryStr);
        recordsTotal = reviewService.getFaultJobCount();
        recordsFiltered = recordsTotal;
        return "faultJobList";
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

    public List<ResultMap> getTelJob() {
        return telJob;
    }

    public void setTelJob(List<ResultMap> telJob) {
        this.telJob = telJob;
    }

    public List<ResultMap> getFaultJob() {
        return faultJob;
    }

    public void setFaultJob(List<ResultMap> faultJob) {
        this.faultJob = faultJob;
    }

}
