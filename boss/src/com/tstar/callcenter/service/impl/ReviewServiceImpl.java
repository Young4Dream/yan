package com.tstar.callcenter.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.callcenter.dao.autogenerate.TelJobMapper;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
    
    @Resource
    TelJobMapper telJobMapper;
    
    private int telJobCount;
    private int faultJobCount;

    
    public List<ResultMap> getTelJobList(String queryStr) {
        
        // TODO Auto-generated method stub
        ResultMap params = new ResultMap();
        params.put("v_QueryStr", queryStr);
        params.put("cv_1", new ArrayList<ResultMap>());//传入一个jdbc游标，用于接收返回参数
        telJobMapper.getTelJobList(params);
        setTelJobCount(Integer.parseInt(String.valueOf(params.get("v_count"))));
        List<ResultMap> telJobList = (List<ResultMap>)params.get("cv_1");
        return telJobList;
    }
    
    
    public List<ResultMap> getFaultJobList(String queryStr) {
        
        // TODO Auto-generated method stub
        ResultMap params = new ResultMap();
        params.put("v_QueryStr", queryStr);
        params.put("cv_1", new ArrayList<ResultMap>());//传入一个jdbc游标，用于接收返回参数
        telJobMapper.getFaultJobList(params);
        setFaultJobCount(Integer.parseInt(String.valueOf(params.get("v_count"))));
        List<ResultMap> faultJobList = (List<ResultMap>)params.get("cv_1");
        return faultJobList;
    }
    
    public void setTelJobCount(int telJobCount) {
        this.telJobCount = telJobCount;
    }

    public int getTelJobCount() {
        return telJobCount;
    }

    public int getFaultJobCount() {
        return faultJobCount;
    }

    public void setFaultJobCount(int faultJobCount) {
        this.faultJobCount = faultJobCount;
    }

}
