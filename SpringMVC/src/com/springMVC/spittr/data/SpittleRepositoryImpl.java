package com.springMVC.spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springMVC.spittr.Spittle;
@Component
public class SpittleRepositoryImpl implements SpittleRepository{

	public List<Spittle> findSpittle(long max, int count) {
		List<Spittle> spittleList=new ArrayList<Spittle>();
		for(int k=0;k<count;k++){
			spittleList.add(new Spittle("spittle"+k,new Date()));
		}
		return spittleList;
	}

}
