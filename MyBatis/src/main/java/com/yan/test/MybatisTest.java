package com.yan.test;

import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import com.yan.dao.mapper.DeptMapper;
import com.yan.dao.mapper.EmpMapper;
import com.yan.po.Dept;
import com.yan.po.Emp;
import com.yan.util.OrclSqlSessionFactoryUtil;

public class MybatisTest {
public static void main(String[] args) {
	SqlSession sqlSession=null;
	sqlSession=OrclSqlSessionFactoryUtil.openSqlSession();
	EmpMapper empMapper=sqlSession.getMapper(com.yan.dao.mapper.EmpMapper.class);
	Emp emp=new Emp();
	//根据员工编号查找员工姓名
	emp=empMapper.selectByPrimaryKey((short)7369);
	System.out.println("编号为7369的员工姓名为："+emp.getEname());
	
	/******************************************
	 * 通过association获取部门信息
	 *******************************************/
//	emp=empMapper.findByAss((short)7369);
//	/*取得部门名称*/
//	System.out.println("编号为7369的员工的部门为："+emp.getDept().getDname());
//	/*取得部门位置*/
//	System.out.println("编号为7369的员工的地址为："+emp.getDept().getLoc());
	
	/********************************************
	 * 通过collection获取员工信息
	 *******************************************/
	Dept dept =new Dept();
    DeptMapper dm=sqlSession.getMapper(com.yan.dao.mapper.DeptMapper.class);
    dept=dm.findEmpsByDname("RESEARCH");
    Set<Emp> set=new HashSet<Emp>();
    set=dept.getEmps();
    System.out.println("============RESEARCH部门的童鞋们=============");
    for(Emp e:set){
        System.out.println(e.getEname());
    }
    /**
     * if:根据条件动态查询
     */
    Emp emp1 = new Emp("SCOTT");
    emp1=empMapper.selectByDynParams(emp1);
    System.out.println("================以下语句通过动态SQL生成================");
    System.out.println(emp1.getEname()+"的工作是："+emp1.getJob());
}}
