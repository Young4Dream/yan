package com.yan.test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import com.yan.dao.mapper.DeptMapper;
import com.yan.dao.mapper.EmpMapper;
import com.yan.po.Dept;
import com.yan.po.Emp;
import com.yan.po.EmpExample;
import com.yan.po.EmpExample.Criteria;
import com.yan.util.OrclSqlSessionFactoryUtil;

public class MybatisTest {
@SuppressWarnings({"deprecation" })
public static void main(String[] args) throws ParseException {
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
	emp=empMapper.findByAss((short)7369);
	/*取得部门名称*/
	System.out.println("编号为7369的员工的部门为："+emp.getDept().getDname());
	/*取得部门位置*/
	System.out.println("编号为7369的员工的地址为："+emp.getDept().getLoc());
	
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
     * 动态SQL-if
     */
    emp = new Emp("SCOTT");
    emp=empMapper.selectByDynParamsIf(emp);
    System.out.println("================以下语句通过动态SQL生成================");
    System.out.println(emp.getEname()+"的工作是："+emp.getJob());
    /**
     * 动态SQL-choose
     */
    System.out.println("=========empno\\ename 均不为空,但ename是错误的==========");
    emp = new Emp((short) 7369,"HAHA");
    emp = empMapper.selectByDynParamsChoose(emp);
    System.out.println(emp.getEname());
    System.out.println("=========empno为空，ename不为空==========");
    emp = new Emp(null,"ADAMS");
    emp = empMapper.selectByDynParamsChoose(emp);
    System.out.println(emp.getHiredate());
    System.out.println("=========没有参数==========");
    emp = new Emp();
    emp = empMapper.selectByDynParamsChoose(emp);
    System.out.println(emp.getEname());
    /**
     * 动态SQL-foreach
     */
//    short[] deptnos=new short[]{10,30};
    List<Short> deptnos = new ArrayList<Short>();
    List<Emp> empList=new ArrayList<Emp>();
    deptnos.add((short) 10);
    deptnos.add((short) 30);
    empList=empMapper.selectByDynParamsForeach(deptnos);
    for(Emp e:empList){
    	System.out.println(e.getEname());
    }
    /**
     * 动态SQL-bind
     */
    BigDecimal bd = new BigDecimal(4000.00);
    emp = empMapper.selectByDynParamsBind("KING",bd);
    System.out.println(emp.getJob());
    /**
     * 通过example方式获取对象
     */
    EmpExample empExample=new EmpExample();  
    Criteria empCriteria=empExample.createCriteria(); 
    DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    DateFormat formatter = DateFormat.getDateInstance();
    Date begin=df.parse("1972-02-19");
    Date end=formatter.parse("1982-02-19");
    empCriteria.andHiredateBetween(begin, end);  
    empExample.setOrderByClause("deptno desc");  
    empExample.setDistinct(false); 
    empList=empMapper.selectByExample(empExample);
    System.out.println(begin.toLocaleString()+"到"+end.toLocaleString()+"的在职人员有：");
    for(int i=0;i<empList.size();i++){
    	System.out.println(empList.get(i).getEname()+empList.get(i).getDeptno());
    }
}}
