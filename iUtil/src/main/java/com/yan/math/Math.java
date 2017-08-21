package com.yan.math;

public class Math{
	/**
	 * 求组合结果
	 * @param total
	 * @param selected
	 * @return 组合情况的可能数
	 */
	static int C(Integer total,Integer selected){
		if(total-selected<0){
			try {
				throw new Exception("总数必须大于选择数~");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int f=factorial(total);
		int fs=factorial(total-selected);
		int s=factorial(selected);
		int t=f/fs;
		return t/s;
	}
	/**
	 * 求排列结果
	 * @param total
	 * @param selected
	 * @return 排列情况的可能数
	 */
	static int A(Integer total,Integer selected){
		if(total-selected<0){
			try {
				throw new Exception("总数必须大于选择数~");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int f=factorial(total);
		int s=factorial(total-selected);
		return f/s;
	}
	/**
	 * 求一个数字的阶乘
	 * @param srcInt
	 * @return 此数字的阶乘
	 */
	static int factorial(Integer srcInt){
		if(srcInt<0){
			try {
				throw new Exception("输入数字不能小于0！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int result=1;
		for(int i=1;i<=srcInt;i++){
			result=result*i;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(factorial(0));
		System.out.println(A(5, 5));
		System.out.println(C(5, 3));
		System.out.println(A(4,2));
	}
}
