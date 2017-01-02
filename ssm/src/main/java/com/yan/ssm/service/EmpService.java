package com.yan.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.yan.ssm.pojo.Emp;
import com.yan.ssm.pojo.EmpExample;

public interface EmpService {
	int countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(Short empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(Short empno);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}
