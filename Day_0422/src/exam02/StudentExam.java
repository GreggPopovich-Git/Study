package exam02;

import java.util.Scanner;

/* [입력작업예시]
 * 학생등록 : 학번,이름,성별,점수1,.... 점수 10;
 * 		 : 1101,이학생,F,90,80,77,66,78,89,88,87,68,99
 * 		 : 1102,박학생,F,90,80,77,66,78,89,88,87,68,99
 * 		 : 1103,김학생,F,90,80,77,66,78,89,88,87,68,99
 * 		 : 1104,강학생,F,90,80,77,66,78,89,88,87,68,99
 * 		 : 0000 - > 입력종료
 * 			최대 10명
 */
public class StudentExam extends Student {
	int[] score = new int[10];
	public StudentExam() {}
	public StudentExam(String hakbun, String irum, String gender, int[] score) {
		this.hakbun = hakbun;
		this.irum = irum;
		this.gender = gender;
		this.score = score;
	}
	void stuTitle() {
		System.out.print("학번\t이름\t성별\t");
		for (int x = 0; x < score.length; x++) {
			System.out.print("점수" + (x+1) + "\t");
		}
		System.out.println();
	}
	void stuPrint() {
		String imsi="여";
		if(gender.equalsIgnoreCase("m"))
			imsi="남";
		System.out.print(hakbun+"\t"+irum+"\t"+imsi+"\t");
		for (int x = 0; x < score.length; x++) {
			System.out.print(score[x] + "\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		StudentExam sa[] = new StudentExam[10];
		Scanner scn = new Scanner(System.in);
		int cnt = 0;
		for(int x = 0; x < sa.length; x++) {
			StudentExam ss = new StudentExam();
			ss.score = new int[10];
			System.out.print("학생 등록 : ");
			String imsi[] = scn.nextLine().split(",");
			if (imsi[0].equals("0000"))
				break;
			for(int y = 0; y < ss.score.length; y++) {
				 ss.score[y] = Integer.parseInt(imsi[y+3]);
			}
			sa[x] = new StudentExam(imsi[0],imsi[1],imsi[2],ss.score);
			cnt++;
		}
		sa[0].stuTitle();
		for (int x = 0; x < cnt; x++) {
			sa[x].stuPrint();
		}
		scn.close();
	}
}