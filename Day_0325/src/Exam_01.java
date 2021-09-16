import java.util.Scanner;

// 키보드로 전수를 입력 받아서 홀수 짝수 판별
public class Exam_01 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Input Number : ");
		int score = scn.nextInt();
		int na = score % 2;
		System.out.println(score + "는 " + na);
		
		int na2 = score % 5;
		System.out.print(score + "는 " + na2);
		
		scn.close();

	}

}
