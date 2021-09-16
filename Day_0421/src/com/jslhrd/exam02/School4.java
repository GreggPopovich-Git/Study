package com.jslhrd.exam02;
import java.util.Scanner;
public class School4 {
	public static void main(String[] args) {
		//학생객체
		Student[] student = new Student[5];
		student[0] = new Student("1102","박학생","2222","F","951115");
		student[1] = new Student("1101","이학생","1111","M","880311");
		student[2] = new Student("1103","김학생","3333","F","920506");
		student[3] = new Student("1104","최학생","4444","M","861230");
		student[4] = new Student("1105","배학생","5555","F","990108");
		//점수객체
		Score2 score1;
		Scanner scn = new Scanner(System.in);
		System.out.print("성적 등록 : ");
		score1 = new Score2();
		String hakbun = scn.next(); // 학번입력
		int x;
		for (x = 0; x < student.length; x++) {
			if (hakbun.equals(student[x].getHakbun())) {
				break;
			}
		}
		score1.setStudent(student[x]);
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
		System.out.println("학번\t이름\t성별\t총점\t평균\t판정");
		System.out.print(score1.getStudent().getHakbun() + "\t");
		System.out.print(score1.getStudent().getName() + "\t");
		System.out.print(score1.getStudent().getGender() + "\t");
		System.out.print(score1.getTot() + "\t");
		System.out.print(score1.getAve() + "\t");
		System.out.print(score1.getMemo() + "\n");
		scn.close();
	}
}