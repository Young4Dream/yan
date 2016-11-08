package com.spring.mvc.dao.impl;
/**
 * name:SpittleDaoImpl
 * @author yan
 * discreption:定义SPITTLE表的增删改查操作
 * modify: 2016-11-02
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dao.SpittleDao;
import com.spring.mvc.pojo.Spittle;
@Repository
public class SpittleDaoImpl implements SpittleDao{
	
	private JdbcTemplate jt;
//	@Autowired
	private NamedParameterJdbcTemplate npjt;
	@Override
	public Spittle findById(int id) {
		String sql="select * from spittle where id=?";
		RowMapper<Spittle> rowMapper=new BeanPropertyRowMapper<Spittle>(Spittle.class);
		Spittle spittle=jt.queryForObject(sql, rowMapper, id);
		return spittle;
	}

	@Override
	public List<Spittle> findAll() {
		List<Spittle> list=new ArrayList<Spittle>();
		try {
			String sql="select id,message,time,latitude,longitude from spittle";
			RowMapper<Spittle> rowMapper=new BeanPropertyRowMapper<Spittle>(Spittle.class);
			list = jt.query(sql, rowMapper);
			System.out.println("进入com.spring.mvc.dao.impl.SpittleDaoImpl，自动注入的jt："+jt);
			System.out.println("进入com.spring.mvc.dao.impl.SpittleDaoImpl，查询结果为："+list);
			return list;
		} catch (DataAccessException e) {
			return null;
		}
	}

	public JdbcTemplate getJt() {
		return jt;
	}
	@Autowired
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int update(Spittle s) {
		String sql="update spittle set message=:message,time=:time,LATITUDE=:latitude,LONGTITUDE=:longtitude where id=:id";
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("message", s.getMessage());
		paramMap.put("time", s.getTime());
		paramMap.put("id", s.getId());
		paramMap.put("latitude", s.getLatitude());
		paramMap.put("longitude", s.getLongitude());
		try {
			int i=npjt.update(sql, paramMap);
			return i;
		} catch (DataAccessException e) {
			return -1;
		}
	}

	@Override
	public int add(Spittle s) {
		String sql="insert into spittle values (:id,:message,:time,:latitude,:longitude)";
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("id", s.getId());
		paramMap.put("message", s.getMessage());
		paramMap.put("time", s.getTime());
		paramMap.put("latitude", s.getLatitude());
		paramMap.put("longitude", s.getLongitude());
		System.out.println(paramMap.toString());
		System.out.println(s);
		try {
			return npjt.update(sql, paramMap);
		} catch (DataAccessException e) {
			return -1;
		}
	}

	@Override
	public int delete(int id) {
		try {
			String sql="delete spittle where id=?";
			return jt.update(sql, id);
		} catch (DataAccessException e) {
			return -1;
		}
	}

}
