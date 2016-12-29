package com.yan.dao.mapper;

import com.yan.po.Emp;
import com.yan.po.EmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
	
	Emp findByAss(short empno);
    Emp selectByPrimaryKey(short i);
    
}