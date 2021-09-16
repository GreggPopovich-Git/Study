package com.jslhrd.exam02;

import java.util.Scanner;

public class School2 {

	public static void main(String[] args) {
		//학생객체
		Student student1 = new Student("1102","박학생","2222","F","951115");
		Student student2 = new Student("1101","이학생","1111","M","861005");
		//점수객체
		Score score1;
		Scanner scn = new Scanner(System.in);
		System.out.print("성적 등록 : ");
		score1 = new Score();
		String hakbun = scn.next(); // 학번입력
		score1.setHakbun(hakbun); // 성적객체에 학번 대입
		score1.setKor(scn.nextInt()); // 국어 점수 입력과 동시에 성적객체의 국어에 대입
		score1.setEng(scn.nextInt()); // 영어 점수 입력과 동시에 성적객체의 영어에 대입
		score1.setMat(scn.nextInt()); // 수학 점수 입력과 동시에 성적객체의 수학에 대입
		score1.setTot(score1.getKor() + score1.getEng() + score1.getMat());
		score1.setAve((int)(score1.getTot() / 3. * 100 +0.5) / 100.);
		if(score1.getAve() >= 80)
			score1.setMemo("Pass");
		else
			score1.setMemo("No");
		
		// 성적일람표
		System.out.println("학번\t이름\t성별\t국어\t영어\t수학\t총점\t평균\t판정");
		System.out.print(score1.getHakbun() + "\t");
		if (student1.getHakbun().equals(score1.getHakbun())) {
			System.out.print(student1.getName() + "\t");
			System.out.print(student1.getGender() + "\t");
			
		}
		else {
			System.out.print(student2.getName() + "\t");
			System.out.print(student2.getGender() + "\t");
		}
		System.out.print(score1.getKor() + "\t");
		System.out.print(score1.getEng() + "\t");
		System.out.print(score1.getMat() + "\t");
		System.out.print(score1.getTot() + "\t");
		System.out.print(score1.getAve() + "\t");
		System.out.print(score1.getMemo() + "\t");
		scn.close();
	}
}