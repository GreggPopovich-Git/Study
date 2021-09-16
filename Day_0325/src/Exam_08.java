import java.util.Scanner;

// 키보드로 정수를 입력 받아서 입력받은 값이 홀수이면 true, 짝수이면 false를 출력하는 프로그램 작성

public class Exam_08 {
	public static void main(String[] args) {
		System.out.print("정수입력 : ");
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		boolean bool = num%2==1;
		
		System.out.println(num + "는 " + bool);
		//또는
		int na = num%2;
		System.out.println(num + "는 " + (na==1));
		
		scn.close();
	}

}
