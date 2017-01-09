package com.tstar.portal.dao;

import java.util.List;

import com.tstar.portal.model.Dept;
import com.tstar.portal.model.ResultMap;

public interface DeptMapper {
    int deleteByPrimaryKey(String id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
    
    List<ResultMap> selectAllDepts();
    
    int deleteByCode(String code);
}