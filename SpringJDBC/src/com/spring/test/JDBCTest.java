package com.spring.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.entity.Dept;

public class JDBCTest {

	private ApplicationContext ctx=null;
	private JdbcTemplate jt=null;
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		jt=(JdbcTemplate) ctx.getBean("jdbcTemplate");
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
	@Test
	public void JdbcTemplateTest(){
		JdbcTemplate j=(JdbcTemplate) ctx.getBean("jdbcTemplate");
		System.err.println(j);
	}
	@Test
	public void updateTest(){
		String sqlUpdate="update emp set ename=? where empno=?";
		jt.update(sqlUpdate,"SMITH",7369);
	}
	@Test
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
	@Test
	public void testQueryForObject(){
		String sql="select deptno,dname,loc from dept where deptno=?";
		RowMapper<Dept> rm=new BeanPropertyRowMapper<Dept>(Dept.class);
		Dept d=jt.queryForObject(sql,rm,20);
		System.err.println(d);
	}
}
