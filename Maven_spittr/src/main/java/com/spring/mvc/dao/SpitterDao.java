package com.spring.mvc.dao;

import java.util.List;

import com.spring.mvc.pojo.Spitter;

public interface SpitterDao {
	Spitter findByUsername(String username);
	List<Spitter> findAll();
	int update(Spitter s);
	int add(Spitter s);
	int delete(int i);
}
