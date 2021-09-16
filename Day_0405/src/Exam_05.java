import java.util.Scanner;

/* 10개의 정수를 입력받아서 배열에 저장 후 합을 구하여 출력
 * 
 */

public class Exam_05 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int score[] = new int[10];
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			System.out.print("정수 : ");
			score[i] = scn.nextInt();
		}
		for (int i = 0; i < 10; i++) {
			sum += score[i];
		}
		double ave = (double)sum/score.length;
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + ave);
		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i] + "\t");
		}
		scn.close();
	}

}
