package com.spring.mvc.dao.impl;
/**
 * name:SpittleDaoImpl
 * @author yan
 * discreption:定义SPITTLE表的增删改查操作
 * modify: 2016-11-02
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dao.SpittleDao;
import com.spring.mvc.jdbc.DBHelper;
import com.spring.mvc.pojo.Spittle;
@Repository
public class SpittleDaoImpl implements SpittleDao{
	@Override
	public Spittle findById(int id) {
		String sql="select * from spittle where id=?";
		RowMapper<Spittle> rowMapper=new BeanPropertyRowMapper<Spittle>(Spittle.class);
		Spittle spittle=DBHelper.jt.queryForObject(sql, rowMapper, id);
		return spittle;
	}

	@Override
	public List<Spittle> findAll() {
		String sql="select * from spittle";
		RowMapper<Spittle> rowMapper=new BeanPropertyRowMapper<Spittle>(Spittle.class);
		List<Spittle> list = DBHelper.jt.query(sql, rowMapper);
		return list;
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
			int i=DBHelper.npjt.update(sql, paramMap);
			return i;
		} catch (DataAccessException e) {
			return -1;
		}
	}

	@Override
	public int add(Spittle s) {
		String sql="insert into spittle values (:id,:message,:time,:latitude,:longtitude)";
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("id", s.getId());
		paramMap.put("message", s.getMessage());
		paramMap.put("time", s.getTime());
		paramMap.put("latitude", s.getLatitude());
		paramMap.put("longitude", s.getLongitude());
		try {
			return DBHelper.npjt.update(sql, paramMap);
		} catch (DataAccessException e) {
			return -1;
		}
	}

	@Override
	public int delete(int id) {
		try {
			String sql="delete spittle where id=?";
			return DBHelper.jt.update(sql, id);
		} catch (DataAccessException e) {
			return -1;
		}
	}

}
