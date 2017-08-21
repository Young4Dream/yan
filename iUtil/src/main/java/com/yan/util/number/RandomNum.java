package com.yan.util.number;

import java.util.HashSet;
import java.util.Set;

public class RandomNum {
public int[] getRandomNum(int max,int size){
	Set<Integer> set=new HashSet<Integer>();
	for(int i=0;i<size;i++){
		Integer r=(int) Math.round(Math.random()*max);
		set.add(r);
	}
	int length=set.size();
	int[] arr=new int[length];
	int start=0;
	for(int num:set){
		arr[start]=num;
		start++;
	}
	return arr;
}
}
