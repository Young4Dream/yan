package com.spring.test;

import java.util.Date;
import java.util.HashMap;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.spring.entity.Dept;

public class JDBCTest {

	private ApplicationContext ctx=null;
	private JdbcTemplate jt=null;
	private NamedParameterJdbcTemplate npjt=null;
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		jt=(JdbcTemplate) ctx.getBean("jdbcTemplate");
		npjt=(NamedParameterJdbcTemplate) ctx.getBean(NamedParameterJdbcTemplate.class);
	}
	@Test
	public void dataSourceTest() {
		//注意引入的是javax.sql.DataSource下的DataSource类
		DataSource ds=(DataSource) ctx.getBean("dataSourceLocal");
		
		try {
			System.err.println(ds.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	@Test
	public void JdbcTemplateTest(){
		JdbcTemplate j=(JdbcTemplate) ctx.getBean("jdbcTemplate");
		System.err.println(j);
	}
//	@Test
	public void updateTest(){
		String sqlUpdate="update emp set ename=? where empno=?";
		jt.update(sqlUpdate,"SMITH",7369);
	}
//	@Test
	public void testBatchUpdate(){
		//批量修改
		String[] s=new String[]{"update emp set ename='SMITH1' where empno=7369","update emp set ename='SMITH' where empno=7369"};
		jt.batchUpdate(s);
		//批量添加
		List<Object[]> addList = new ArrayList<Object[]>();
		addList.add(new Object[]{52,"AA","SHANGHAI"});
		addList.add(new Object[]{62,"BB","BEIJING"});
		addList.add(new Object[]{72,"CC","XI'AN"});
		addList.add(new Object[]{82,"DD","HANGZHOU"});
		jt.batchUpdate("insert into scott.dept values (?,?,?)",addList);
		//批量删除
		List<Object[]> delList = new ArrayList<Object[]>();
		delList.add(new Integer[]{40});
		jt.batchUpdate("delete dept where deptno>?",delList);
	}
	/**
	 * 查询单条数据，与实体类对应
	 */
//	@Test
	public void testQueryForObject(){
		String sql="select deptno,dname,loc from dept where deptno=?";
		RowMapper<Dept> rm=new BeanPropertyRowMapper<Dept>(Dept.class);
		Dept d=jt.queryForObject(sql,rm,20);
		System.err.println(d);
	}
	/**
	 * 查询结果集，与实体类的集合对应
	 */
//	@Test
	public void testQueryForList(){
		String sql="select * from dept where deptno>?";
		RowMapper<Dept> re=new BeanPropertyRowMapper<Dept>(Dept.class);
		List<Dept> dept=jt.query(sql, re,20);
		System.out.println(dept);
	}
	/**
	 * 获取单列的值，或做统计查询
	 */
//	@Test
	public void testQueryColumnOrCount(){
		//获取统计信息
		String sql="select count(empno) from emp";
		Long l=jt.queryForObject(sql, Long.class);
		System.err.println(l);
		//获取单列信息
		String sql4Date="select hiredate from emp";
		RowMapper<Date> re=new BeanPropertyRowMapper<Date>(Date.class);
		List<Date> d=jt.query(sql4Date, re);
		System.err.println(d);
	}
	/**
	 * NamedParameterJDBCTemplate用法测试，以update为例
	 */
	@Test
	public void testNamedParameterJDBCTemplate(){
		String sql="insert into dept values (:deptno,:dname,:loc)";//此处参数是可以自由命名的
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("deptno", 94);
		map.put("dname", "管理部");
		map.put("loc", "金华");
		npjt.update(sql, map);
	}
	/**
	 * 使用SqlParameterSource类与实体类对应，此时参数命名需与实体类属性名对应
	 * SqlParameterSource sps = new BeanPropertySqlParameterSource(对象)
	 */
	@Test
	public void testNamedParameterJDBCTemplateByEntity(){
		String sql="insert into dept values (:deptno,:dname,:loc)";//此处参数命名需与实体类属性名相同
		SqlParameterSource sps=new BeanPropertySqlParameterSource(new Dept(88, "业务部", "北京"));
		npjt.update(sql, sps);
	}
}
