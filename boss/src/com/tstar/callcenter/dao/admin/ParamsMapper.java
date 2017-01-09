package com.tstar.callcenter.dao.admin;

import java.util.List;

import com.tstar.callcenter.model.Params;
import com.tstar.callcenter.pub.data.ResultMap;

public interface ParamsMapper {
    
    List<ResultMap> selectParamsList(ResultMap map);
    
    int selectParamsCount(Params params);
    
    int paramsInsert(Params params);
    
    int paramsUpdate(Params params);
    
    int paramsDelete(Params params);
}
