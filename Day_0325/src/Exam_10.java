import java.util.Scanner;

//논리연산자(!(Not), &&(And), ||(Or))
public class Exam_10 {
	public static void main(String[] args) {
		System.out.println("5>3 %% 3<4 : " + (5<3 && 3<4));
		System.out.println("5>3 %% 3<4 : " + (5<3 & 3<4));
		System.out.print("정수 입력 : ");
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		//1. boolean
		boolean bool = num%2==0 && num%3==0;
		
		System.out.println(num + "은 짝수이면서 3의 배수 인가? : " + bool);
		//2. int
		int na2 = num%2;
		int na3 = num%3;
		System.out.println(num + "은 짝수이면서 3의 배수 인가? : " + (na2==0 && na3==0));
		
		scn.close();
		
	}

}
