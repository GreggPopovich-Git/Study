import java.util.Scanner;

/* 키보드로 이름, 국어, 영어, 수학 입력 받아서 이름, 총점, 평균, 학점을 출력
 * [입력 예시]
 * 입력 자료 : 홍길동 39 90 80
 * [출력 예시]
 * 이름 : 홍길동
 * 총점 : 209
 * 평균 : 69
 * 학점 : D
 * 판정 : NoPass
 * [처리 조건]
 * 1. 학점은 평균이 100~90이면 'A', 89~80이면 'B', 79~70이면 'C', 69~60이면 'D', 59~0이면 'F'
 * 2. 판정은 학점이 'C'이상일 경우 "PASS"를 출력하고 아니면 "NoPass" 출력한다.
 */
public class Exam_08 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("입력 자료 : ");
		String name = scn.next();
		int kor = scn.nextInt();
		int eng = scn.nextInt();
		int mat = scn.nextInt();
		int tot = kor + eng + mat;
		double ave = (int)(tot/3.*100+0.5)/100.;
		char score;
		String judge;
		
		if (kor>=0 && eng>=0 && mat>=0 && kor<=100 && eng<=100 && mat<=100) {
			switch ((int)ave/10) {
			case 10:
			case 9:
				score = 'A';
				judge = "PASS";
				break;
			case 8:
				score = 'B';
				judge = "PASS";
				break;
			case 7:
				score = 'C';
				judge = "PASS";
				break;
			case 6:
				score = 'D';
				judge = "NoPass";
				break;
			default:
				score = 'F';
				judge = "NoPass";
			}
			System.out.println("이름 : " + name);
			System.out.println("총점 : " + tot);
			System.out.println("평균 : " + ave);
			System.out.println("학점 : " + score);
			System.out.println("판정 : " + judge);
		}
		else {
			System.out.println("입력오류입니다");
		}
		scn.close();
	}

}
