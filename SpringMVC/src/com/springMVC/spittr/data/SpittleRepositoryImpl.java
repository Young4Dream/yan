package com.springMVC.spittr.data;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
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
			  Date currentTime = new Date();
			  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			  String dateString = formatter.format(currentTime);
			  try {
				  Date currentTime_2 = formatter.parse(dateString);
				spittleList.add(new Spittle("spittle"+k,currentTime_2));
			} catch (ParseException e) {
				e.printStackTrace();
				System.err.println("errr");
			}
		}
		return spittleList;
	}

}
