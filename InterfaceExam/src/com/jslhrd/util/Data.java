package com.jslhrd.util;
/**
 * 
 * @author Gil Young Park
 * @version 1.0
 *
 */
public interface Data {
	/**
	 * 인자로 전달된 매개변수에서 최대값을 찾아서 리턴
	 * @param var 정수리스트(1,2,3,4,5 . .)
	 * @return int
	 */
	int getMax(int ... var);
	/**
	 * 인자로 전달된 매개변수에서 최소값을 찾아서 리턴
	 * @param var 정수리스트(1,2,3,4,5 . .)
	 * @return int
	 */
	int getMin(int ... var);
	void sort(int[] var, boolean bool);
	default int getSum(int ... var) {
		int sum = 0;
		for (int x : var)
			sum += x;
		return sum;
	}
}
