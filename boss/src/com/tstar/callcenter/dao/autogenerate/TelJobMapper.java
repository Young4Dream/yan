package com.tstar.callcenter.dao.autogenerate;

import com.tstar.callcenter.model.autogenerate.TelJob;
import com.tstar.callcenter.model.autogenerate.TelJobWithBLOBs;
import com.tstar.callcenter.pub.data.ResultMap;

public interface TelJobMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TelJobWithBLOBs record);

    int insertSelective(TelJobWithBLOBs record);

    TelJobWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TelJobWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TelJobWithBLOBs record);

    int updateByPrimaryKey(TelJob record);
    
    //查询电话工单
    public void getTelJobList(ResultMap map);
    
    //查询故障工单
    public void getFaultJobList(ResultMap map);
}