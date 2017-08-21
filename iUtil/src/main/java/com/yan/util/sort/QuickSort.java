package com.yan.util.sort;

import com.yan.util.number.RandomNum;

public class QuickSort {
	//快速排序  
	public void quick_sort(int s[], int l, int r)  
	{  
	    if (l < r)  
	    {  
	        //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1  
	        int i = l, j = r, x = s[l];  
	        while (i < j)  
	        {  
	            while(i < j && s[j] >= x) // 从右向左找第一个小于x的数  
	                j--;    
	            if(i < j)   
	                s[i++] = s[j];  
	              
	            while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数  
	                i++; 
	            if(i < j)   
	                s[j--] = s[i];
	        }
	        s[i] = x;  
	        quick_sort(s, l, i - 1); // 递归调用   
	        quick_sort(s, i + 1, r);  
	    }  
	}
	public static void main(String[] args) {
		RandomNum random=new RandomNum();
		int [] arr=random.getRandomNum(1000, 10);
		System.out.println(arr.getClass().getTypeParameters());;
		for(int i:arr){
			System.out.print(i+"\t");
		}
		new QuickSort().quick_sort(arr, 0, arr.length-1);
		System.out.println();
		for(int i:arr){
			System.out.print(i+"\t");
		}
	}
}
