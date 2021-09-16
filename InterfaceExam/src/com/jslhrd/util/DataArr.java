package com.jslhrd.util;

public interface DataArr extends Data {
	/**
	 * 인자로 전달된 매개변수에서 최대값을 찾아서 리턴
	 * @param var 정수리스트(1,2,3,4,5 . .)
	 * @return int
	 */
	int getMax(int[] var);
	/**
	 * 인자로 전달된 매개변수에서 최소값을 찾아서 리턴
	 * @param var 정수리스트(1,2,3,4,5 . .)
	 * @return int
	 */
	int getMin(int[] var);
	
	default int getSum(int[] var) {
		int sum = 0;
		for (int x = 0; x < var.length; x++)
			sum += var[x];
		return sum;
	}
}
