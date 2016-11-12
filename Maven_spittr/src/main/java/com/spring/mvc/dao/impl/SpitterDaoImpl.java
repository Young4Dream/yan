package com.spring.mvc.dao.impl;

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

import com.spring.mvc.dao.SpitterDao;
import com.spring.mvc.pojo.Spitter;
@Repository
public class SpitterDaoImpl implements SpitterDao{
	@Autowired
	private JdbcTemplate jt;
	@Autowired
	private NamedParameterJdbcTemplate npjt;
	@Override
	public List<Spitter> findAll() {
		String sql="select * from spitter";
		List<Spitter> list=new ArrayList<Spitter>();
		list=jt.queryForList(sql, Spitter.class);
		return list;
	}

	@Override
	public int update(Spitter s) {
		String sql="update spitter set firstname" +
				"=:firstname,lastname=:lastname,email=:email,username=:username,password=:password,loc_img=:loc_img where id=:id";
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("firstname", s.getFirstName());
		map.put("lastname", s.getLastName());
		map.put("email", s.getEmail());
		map.put("username", s.getUsername());
		map.put("password", s.getPassword());
		map.put("loc_img", s.getLoc_img());
		try {
			npjt.update(sql, map);
			return 1;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return -1;
		}
	}
/**
 * 插入的sql语句最好写全，不然会因为顺序不对而错位
 */
	@Override
	public int add(Spitter s) {
		String sql="insert into spitter(id,firstname,lastname,username,password,email,loc_img) values(" +
				"seq_spitter.nextval,:firstname,:lastname,:username,:password,:email,:loc_img" +
				")";
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("firstname", s.getFirstName());
		map.put("lastname", s.getLastName());
		map.put("email", s.getEmail());
		map.put("username", s.getUsername());
		map.put("password", s.getPassword());
		map.put("loc_img", s.getLoc_img());
		try {
			System.out.println("开始添加Spitter数据");
			for(Map.Entry<String, Object> entry:map.entrySet()){
				System.out.println(entry.getKey()+"-->"+entry.getValue());
			}
			System.out.println("sql:"+sql);
			int i=npjt.update(sql, map);
			return i;
		} catch (DataAccessException e) {
			return -1;
		}
	}

	@Override
	public int delete(int i) {
		String sql="delete spitter where id=?";
		try {
			return jt.update(sql, i);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public Spitter findByUsername(String username) {
		String sql="select id,firstname,lastname,email,loc_img from spitter where username=?";
		RowMapper<Spitter> rowMapper;
		rowMapper=new BeanPropertyRowMapper<Spitter>(Spitter.class);
		Spitter s;
		try {
			s = jt.queryForObject(sql, rowMapper,username);
			return s;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
}
