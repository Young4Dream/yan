package com.tstar.callcenter.pub.tools;

import java.util.ArrayList;
import java.util.List;

import com.tstar.callcenter.model.TreeInfo;



public class ListUtil{
	
	
	
	public static void quicksort(List<TreeInfo> n, int left, int right) {
        int dp;
        if (left < right) {

            dp = partition(n, left, right);

            quicksort(n, left, dp - 1);

            quicksort(n, dp + 1, right);
        }
    }

    /**
     *  Returns the position of the intermediate value, this function is to do this  .
     * 
     * @param n         An array to be sorted  
     * @param left      Array left ordinal  
     * @param right     Array right ordinal  
     * @return         
     */

	private static int partition(List<TreeInfo> n, int left, int right) {
        int lo, hi;
        long pivot;
        TreeInfo t = new TreeInfo();
        TreeInfo tPivot = new TreeInfo();
        tPivot = n.get(left);
        pivot = n.get(left).getId();
        lo = left - 1;
        hi = right + 1;

        while (lo + 1 != hi) {
            if (n.get(lo + 1).getId() <= pivot)
                lo++;
            else if (n.get(hi - 1).getId() > pivot)
                hi--;
            else {
                t = n.get(lo+1);
                n.set(++lo, n.get(hi - 1));
                n.set(--hi, t);
            }
        }
        
        n.set(left, n.get(lo));
        n.set(lo, tPivot);
        
        return lo;
    }

	
	
	
	public static List<TreeInfo> compareTo(List<TreeInfo> dataChangeList,List<TreeInfo> dataList) {
		List<TreeInfo> difTree = new ArrayList<TreeInfo>();
		
		quicksort(dataChangeList,0,dataChangeList.size()-1);
		quicksort(dataList,0,dataList.size()-1);
		TreeInfo t1,t2;
		for(int i=0;i<dataList.size();i++){
			t1=dataList.get(i);
			t2=dataChangeList.get(i);
			
			if(t1.getParentId()!=t2.getParentId()){
				difTree.add(dataChangeList.get(i));
			}else{
				if(t1.getSort()!=t2.getSort()){
					difTree.add(dataChangeList.get(i));
				}
			}
			
		}

		return difTree;
		
	}
	
	
	
	
	
	
	
	
	

	

}
