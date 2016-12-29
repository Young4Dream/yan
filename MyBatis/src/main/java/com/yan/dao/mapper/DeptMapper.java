package com.yan.dao.mapper;

import com.yan.po.Dept;
import com.yan.po.DeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
	
	Dept findEmpsByDname(String dname);

    Dept selectByPrimaryKey(Short deptno);
}