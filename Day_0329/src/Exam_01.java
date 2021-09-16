import java.util.Scanner;

// 제어 문 (조건, 비교 판단문)
// 키보드로 점수를 입력 받아서 90이상이면 출력하는 프로그램 작성
public class Exam_01 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("점수 입력 : ");
		int score = scn.nextInt();
		
		if (score >= 90) {
			System.out.println("입력값은 " + score);
		}
		System.out.println("프로그램이 종료되었습니다.");
		scn.close();
	}

}
