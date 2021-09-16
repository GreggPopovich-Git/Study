import java.util.Arrays;

import com.jslhrd.util.*;

/* 키보드로 정수 n개를 입력 받아서
 * 1. 최대값
 * 2. 최소값을 구하는 프로그램 작성
 * 3. 오름차순 정렬 후 출력
 */
public class Exam_01 {
	public static void main(String[] args) {
		Data data = new DataPro();
		System.out.println(data.getMax(1,2,3,4,5)); // 최대값 테스트
		System.out.println(data.getMin(1,2,3,4,5)); // 최소값 테스트
		System.out.println(data.getSum(1,2,3,4,5)); // 합계 테스트
		int[] score = {3,8,5,9,2,4,8,5};
		System.out.println("Sort 전 : " + Arrays.toString(score)); // 배열 출력 테스트
		data.sort(score, true);
		System.out.println("Sort 후 : " + Arrays.toString(score)); // sort된 배열 출력 테스트
		
	}

}
