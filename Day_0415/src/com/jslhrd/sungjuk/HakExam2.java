package com.jslhrd.sungjuk;

import java.util.Scanner;

class Hak2 {
	int hakbun; //맴버 변수 또는 맴버 필드라고 한다. 명시적 초기화 가능, 초기화 안하면 자동 초기화
	String name;
	int score;
	String by;
	
	public void print() { //출력 메소드 생성
		if(score >= 90)
			by = "수";
		else if (score >= 80)
			by = "우";
		else
			by = "가";
		System.out.println("학번 : " + hakbun);
		System.out.println("이름 : " + name);
		System.out.println("점수 : " + score);
		System.out.println("학점 : " + by);
	}
}
public class HakExam2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Hak2 h1 = new Hak2(); //인스턴스(객체) 생성 : 자동 초기화
		System.out.print("학생등록 : ");
		h1.hakbun = scn.nextInt();
		h1.name = scn.next();
		h1.score = scn.nextInt();
		
		h1.print();
		
		Hak2 h2 = new Hak2();
		System.out.print("학생등록 : ");
		h2.hakbun = scn.nextInt();
		h2.name = scn.next();
		h2.score = scn.nextInt();
		
		h2.print();
		
		scn.close();
	}

}