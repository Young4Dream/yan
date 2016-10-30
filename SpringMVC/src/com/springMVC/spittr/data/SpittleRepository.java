package com.springMVC.spittr.data;

import java.util.List;

import com.springMVC.spittr.Spittle;
public interface SpittleRepository {
	List<Spittle> findSpittle(long max,int count);
}
