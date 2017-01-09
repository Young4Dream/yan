package com.tstar.callcenter.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.callcenter.model.Params;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.ParamsService;

public class ParamsAction extends ActionSupport {
    
private static final long serialVersionUID = 1L;
    
    private Params params = new Params();
    private List<ResultMap> paramsList = new ArrayList<ResultMap>();
    private int recordsTotal;
    private int draw;
    private int recordsFiltered;
    private int start;
    private int length;
    private String res;
    
    @Resource
    private ParamsService paramsService;
    
    public String goToParamConfPage(){
        return "paramConfPage";
    }
    
    public String selectParamsList(){
        paramsList = paramsService.selectParamsList(params, start, length);
        recordsTotal = paramsService.selectParamsCount(params);
        recordsFiltered = recordsTotal;
        return "numJson";
    }
    
    public String paramsInsert(){
        int i= 0;
        i = paramsService.paramsInsert(params);
        if(i > 0){
            setRes("受理成功");
        }else{
            setRes("受理失败");
        }
        return "paramsInsert";
    }
    
    public String paramsUpdate(){
        int i= 0;
        i = paramsService.paramsUpdate(params);
        if(i > 0){
            setRes("受理成功");
        }else{
            setRes("受理失败");
        }
        return "paramsUpdate";
    }
    
    public String paramsDelete(){
        int i= 0;
        i = paramsService.paramsDelete(params);
        if(i > 0){
            setRes("受理成功");
        }else{
            setRes("受理失败");
        }
        return "paramsDelete";
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public List<ResultMap> getParamsList() {
        return paramsList;
    }

    public void setParamsList(List<ResultMap> paramsList) {
        this.paramsList = paramsList;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
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
}
