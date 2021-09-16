package com.jslhrd.sungjuk;

import java.util.Scanner;

class Hak3 {
	int hakbun; //맴버 변수 또는 맴버 필드라고 한다. 명시적 초기화 가능, 초기화 안하면 자동 초기화
	String name;
	int score;
	String by;
	Hak3(){} //디폴트 생성자
	Hak3(int hakbun) {
		this.hakbun = hakbun;
	}
	Hak3(int hakbun, String name) {
		this.hakbun = hakbun;
		this.name = name;
	}
	Hak3(int hakbun, String name, int score) { //메소드 오버로드 : 메소드 이름이 같아야 하고 
		this.hakbun = hakbun;
		this.name = name;
		this.score = score;
		//score();
		//print();
	}
	public void score() {
		if(score >= 90)
			by = "수";
		else if (score >= 80)
			by = "우";
		else
			by = "가";
		print();
	}
	public void print() { //출력 메소드 생성
		System.out.println("학번 : " + hakbun);
		System.out.println("이름 : " + name);
		System.out.println("점수 : " + score);
		System.out.println("학점 : " + by);
	}
}
public class HakExam3 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("학생등록 : ");
		int hakbun = scn.nextInt();
		String name = scn.next();
		int score = scn.nextInt();
		Hak3 h1 = new Hak3(hakbun,name,score);
		h1.score();
		h1.print();
		
		Hak3 h2;
		System.out.print("학생등록 : ");
		h2 = new Hak3(scn.nextInt(),scn.next(),scn.nextInt());
		h2.score();
		h2.print();
		
		scn.close();
	}

}