package com.jslhrd.user;

import java.util.Arrays;

import com.jslhrd.util.DataArr;
import com.jslhrd.util.DataArrPro;

public class Exam_02 {

	public static void main(String[] args) {
		DataArr data = new DataArrPro();
		int[] score1 = {1,2,3,4,5};
		System.out.println(data.getMax(score1)); // 최대값 테스트
		System.out.println(data.getMin(score1)); // 최소값 테스트
		System.out.println(data.getSum(score1)); // 합계 테스트
		int[] score2 = {3,8,5,9,2,4,8,5};
		System.out.println("Sort 전 : " + Arrays.toString(score2)); // 배열 출력 테스트
		data.sort(score2, true);
		System.out.println("Sort 후 : " + Arrays.toString(score2)); // sort된 배열 출력 테스트
		
	}

}

