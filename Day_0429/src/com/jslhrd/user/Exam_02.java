package com.jslhrd.user;

import com.jslhrd.util.PersonData;

public class Exam_02 {

	public static void main(String[] args) {
		// 입력자료
		String name = "김학생";
		String birth = "931005";
		int[] score = {89,66,79,89,60,85};
		
		// 객체생성
		PersonData pData = new PersonData(name,birth,score);
		
		pData.dataPrint();
		
		/* 출력 예시
		 * 이름	나이	점수1		점수2		...		총점
		 * 김학생	29	89		66				xx
		 * 
		 */
		
	}

}
