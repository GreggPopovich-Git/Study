package com.jslhrd.sungjuk;

import java.util.Scanner;

class Hak4 {
	int hakbun; //맴버 변수 또는 맴버 필드라고 한다. 명시적 초기화 가능, 초기화 안하면 자동 초기화
	String name;
	int score;
	String by;
	Hak4(){} //디폴트 생성자
	Hak4(int hakbun) {
		this.hakbun = hakbun;
	}
	Hak4(int hakbun, String name) {
		this.hakbun = hakbun;
		this.name = name;
	}
	Hak4(int hakbun, String name, int score) { //메소드 오버로드 : 메소드 이름이 같아야 하고 
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
		//print();
	}
	public void print() { //출력 메소드 생성
		System.out.println("학번 : " + hakbun);
		System.out.println("이름 : " + name);
		System.out.println("점수 : " + score);
		System.out.println("학점 : " + by);
	}
}
public class HakExam4 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Hak4 hArr[] = new Hak4[5];
		//입력
		for (int x = 0; x < 5; x++) {
			System.out.print("학생등록 : ");
			int hakbun = scn.nextInt();
			String name = scn.next();
			int score = scn.nextInt();
			//Hak4 h1 = new Hak4(hakbun,name,score);
			//hArr[x] = h1;
			hArr[x] = new Hak4(hakbun,name,score);
		}
		//출력
		for (int x = 0; x < 5; x++) {
			hArr[x].score();
			hArr[x].print();
		}
		scn.close();
	}

}