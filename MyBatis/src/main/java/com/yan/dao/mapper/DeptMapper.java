package com.yan.dao.mapper;

import com.yan.po.Dept;

public interface DeptMapper {
	
	Dept findEmpsByDname(String dname);

    Dept selectByPrimaryKey(Short deptno);
}