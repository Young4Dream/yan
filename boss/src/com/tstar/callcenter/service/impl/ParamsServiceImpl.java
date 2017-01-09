package com.tstar.callcenter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tstar.callcenter.dao.admin.ParamsMapper;
import com.tstar.callcenter.model.Params;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.ParamsService;

@Service
public class ParamsServiceImpl implements ParamsService {
    
    private static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
    
    @Resource
    private ParamsMapper paramsMapper;

    //@Override
    public int paramsDelete(Params params) {
        // TODO Auto-generated method stub
        int i = paramsMapper.paramsDelete(params);
        return i;
    }

    //@Override
    public int paramsInsert(Params params) {
        // TODO Auto-generated method stub
        int i = paramsMapper.paramsInsert(params);
        return i;
    }

    //@Override
    public int paramsUpdate(Params params) {
        // TODO Auto-generated method stub
        int i = paramsMapper.paramsUpdate(params);
        return i;
    }

    //@Override
    public int selectParamsCount(Params params) {
        // TODO Auto-generated method stub
        int i = paramsMapper.selectParamsCount(params);
        return i;
    }

    //@Override
    public List<ResultMap> selectParamsList(Params params, int start, int length) {
        // TODO Auto-generated method stub
        ResultMap paraMap = new ResultMap();
        if(params != null){
            paraMap.put("paramName", params.getParamName());
        }
//        paraMap.put("pageSize", length);
//        paraMap.put("offset", start);
        PageHelper.startPage(start/length+1, length);
        return paramsMapper.selectParamsList(paraMap);
    }

}
