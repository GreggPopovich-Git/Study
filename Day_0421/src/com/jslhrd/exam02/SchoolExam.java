package com.jslhrd.exam02;

import java.util.Scanner;

/* [입력예시]
 * 성적입력 : 1102, 90, 80, 90 //입력자료항목의 구분은 ,(콤마)
 * 등록완료
 * 성적입력 : 1107, 90, 80, 90 //입력자료항목의 구분은 ,(콤마)
 * 입력오류
 * 성적입력 : 1103, 90, 80, 90 //입력자료항목의 구분은 ,(콤마)
 * 등록완료
 * . . . . . 5명 입력완료시 전체 자료 출력
 * [출력예시]
 * 학번	이름	성별	생년월일	총점	평균	학점
 */
public class SchoolExam {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//학생객체
		Student[] student = new Student[5];
		student[0] = new Student("1102","박학생","2222","F","951115");
		student[1] = new Student("1101","이학생","1111","M","880311");
		student[2] = new Student("1103","김학생","3333","F","920506");
		student[3] = new Student("1104","최학생","4444","M","861230");
		student[4] = new Student("1105","배학생","5555","F","990108");
		//입력
		Score2 score[] = new Score2[5];
		int y;
		boolean flag = true;
		for (int x = 0; x < student.length; x++) {
			flag = true;
			System.out.print("학생 성적 입력 : ");
			String hak[] = scn.nextLine().split(",");
			for (y = 0; y < student.length; y++) {
				if (hak[0].equals(student[y].getHakbun())) {
					flag = false;
					System.out.println("등록완료");
					break;
				}
			}
			if (flag) {
				System.out.println("학번을 찾을 수 없습니다. 다시 입력하세요");
				x--;
				continue;
			}
			score[x] = new Score2(student[y],Integer.parseInt(hak[1]),Integer.parseInt(hak[2]),Integer.parseInt(hak[3]));
		}
		//출력
		System.out.println("학번\t이름\t성별\t생년월일\t총점\t평균\t학점");
		for (int x = 0; x < student.length; x++) {
			System.out.print(score[x].getStudent().getHakbun() + "\t");
			System.out.print(score[x].getStudent().getName() + "\t");
			System.out.print(score[x].getStudent().getGender() + "\t");
			System.out.print(score[x].getStudent().getBirth() + "\t");
			System.out.print(score[x].getTot() + "\t");
			System.out.print(score[x].getAve() + "\t");
			System.out.println(score[x].getMemo() + "\t");
		}
		scn.close();
	}
}