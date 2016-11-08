package com.spring.mvc.dao;

import java.util.List;

import com.spring.mvc.pojo.Spittle;

public interface SpittleDao {
	Spittle findById(int id);
	List<Spittle> findAll();
	int update(Spittle s);
	int add(Spittle s);
	int delete(int i);
}
