import java.util.Scanner;

// 키보드로 점수를 입력 받아서 점수가 80~90 사이면 "Pass"
// 아니면 "NoPass"
public class Exam_06 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("점수 : ");
		int score = scn.nextInt();
		if (score >= 80) {
			if (score <= 90) {
				System.out.println("Pass");
			}
			else {
				System.out.println("NoPass");
			}
		}
		else {
			System.out.println("NoPass");
		}
		if (score >= 80 && score <= 90) {
			System.out.println("Pass");
		}
		else {
			System.out.println("NoPass");
		}
		scn.close();
	}

}