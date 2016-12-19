package com.yan.test;

import org.apache.ibatis.session.SqlSession;

import com.yan.dao.mapper.EmpMapper;
import com.yan.po.Emp;
import com.yan.util.OrclSqlSessionFactoryUtil;

public class MybatisTest {
public static void main(String[] args) {
	SqlSession sqlSession=null;
	sqlSession=OrclSqlSessionFactoryUtil.openSqlSession();
	EmpMapper empMapper=sqlSession.getMapper(com.yan.dao.mapper.EmpMapper.class);
	Emp emp=new Emp();
	emp=empMapper.selectByPrimaryKey((short)7369);
	System.out.println(emp.getEname());
	emp=empMapper.findByAss((short)7369);
	/*取得部门名称*/
	System.out.println(emp.getDept().getDname());
	/*取得部门位置*/
	System.out.println(emp.getDept().getLoc());
}}
