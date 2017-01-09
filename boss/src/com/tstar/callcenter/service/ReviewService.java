package com.tstar.callcenter.service;

import java.util.List;

import com.tstar.callcenter.pub.data.ResultMap;

public interface ReviewService {
    
    public List<ResultMap> getTelJobList(String queryStr);
    
    public void setTelJobCount(int telJobCount);
    
    public int getTelJobCount();
    
    public List<ResultMap> getFaultJobList(String queryStr);
    
    public void setFaultJobCount(int telJobCount);
    
    public int getFaultJobCount();

}
