import java.util.Scanner;

/* 키보드로 이름, 국어, 영어, 수학 점수를 입력 받아서  평균, 판정을 구하여 출력하는 프로그램 작성
 * [입력형식]
 * 학생점수입력 : 김학생 99 78 88
 * [출력형식]
 * 이름        평균         판정
 * 김학생   xx.xx   xx
 * [처리조건]
 * 1. 평균은 소수이하 3자리에서 반올림
 * 2. 평균이 85이상 "합격", 아니면 "불합격"
 */
public class Exam_04 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("학생점수입력 : ");
		String name = scn.next();
		int kor = scn.nextInt();
		int eng = scn.nextInt();
		int mat = scn.nextInt();
		int tot = kor + eng + mat;
		double ave = (int)(tot/3. * 100 + 0.5) / 100.;
		
		String str = (ave>=85) ? "합격" : "불합격";
		System.out.println("이름\t평균\t판정");
		System.out.println(name + "\t" + ave + "\t"+ str);
		
		scn.close();
	}

}
