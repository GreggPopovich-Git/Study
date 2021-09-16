import java.util.Scanner;

// 키보드로 정수를 입력 받아서 입력받은 값이 짝수이면서 3의 배수이면 true, 아니면 false를 출력하는 프로그램 작성
public class Exam_09 {
	public static void main(String[] args) {
		System.out.print("정수 입력 : ");
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		//1. boolean
		boolean bool1 = num%2==0;
		boolean bool2 = num%3==0;
		
		System.out.println(num + "은 짝수이면서 3의 배수 인가? : " + (bool1==true && bool2==true));
		//2. int
		int na2 = num%2;
		int na3 = num%3;
		System.out.println(num + "은 짝수이면서 3의 배수 인가? : " + (na2==0 && na3==0));
		
		scn.close();

	}

}
