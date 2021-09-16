package com.jslhrd.sungjuk;

import java.util.Scanner;

class Hak {
	int hakbun; //맴버 변수 또는 맴버 필드라고 한다. 명시적 초기화 가능, 초기화 안하면 자동 초기화
	String name;
	int score;
	
}
public class HakExam {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Hak h1 = new Hak(); //인스턴스(객체) 생성 : 자동 초기화
		System.out.print("학생등록 : ");
		h1.hakbun = scn.nextInt();
		h1.name = scn.next();
		h1.score = scn.nextInt();
		
		System.out.println("학번 : " + h1.hakbun);
		System.out.println("이름 : " + h1.name);
		System.out.println("점수 : " + h1.score);
		String by = "";
		if(h1.score >= 90)
			by = "수";
		else if (h1.score >= 80)
			by = "우";
		else
			by = "가";
		System.out.println("학점 : " + by);
		
		Hak h2 = new Hak();
		System.out.print("학생등록 : ");
		h2.hakbun = scn.nextInt();
		h2.name = scn.next();
		h2.score = scn.nextInt();
		
		System.out.println("학번 : " + h2.hakbun);
		System.out.println("이름 : " + h2.name);
		System.out.println("점수 : " + h2.score);
		by = "";
		if(h2.score >= 90)
			by = "수";
		else if (h2.score >= 80)
			by = "우";
		else
			by = "가";
		System.out.println("학점 : " + by);
		
		scn.close();
	}

}
