import java.util.Scanner;

/* 키보드로 이름, 국어, 영어, 수학 입력 받아서 이름, 총점, 평균, 판정을 출력
 * [입력 예시]
 * 입력 자료 : 홍길동 39 90 80
 * [출력 예시]
 * 이름 : 홍길동
 * 평균 : 69
 * 판정 : D
 * [처리 조건]
 * 판정은 평균이 100~90 'A', 평균이 89~80 'B', 79~70 'C', 69~60 'D', 59~0 'F'
 */
public class Exam_04 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("입력 자료 : ");
		String name = scn.next();
		int kor = scn.nextInt();
		int eng = scn.nextInt();
		int mat = scn.nextInt();
		// 평균계산
		int tot = kor + eng + mat;
		int ave = tot/3;
		
		String judge = "";  // 등급
/*
		if (ave<=100 && ave>=90) {
			judge = "A";
		}
		else if (ave<90 && ave>=80) {
			judge = "B";
		}
		else if (ave<80 && ave>=70) {
			judge = "C";
		}
		else if (ave<70 && ave>=60) {
			judge = "D";
		}
		else {
			judge = "F";
		}
*/
		if (ave>=90) {
			judge = "A";
		}
		else if (ave>=80) {
			judge = "B";
		}
		else if (ave>=70) {
			judge = "C";
		}
		else if (ave>=60) {
			judge = "D";
		}
		else {
			judge = "F";
		}
		System.out.println("이름 : " + name + "\n평균 : " + ave + "\n판정 : " + judge);

		scn.close();
	}

}
