package com.tstar.callcenter.service;

import java.util.List;

import com.tstar.callcenter.model.Params;
import com.tstar.callcenter.pub.data.ResultMap;

public interface ParamsService {
    public List<ResultMap> selectParamsList(Params params, int start,int length);
    
    public int selectParamsCount(Params params);
    
    public int paramsInsert(Params params);
    
    public int paramsUpdate(Params params);
    
    public int paramsDelete(Params params);
}
