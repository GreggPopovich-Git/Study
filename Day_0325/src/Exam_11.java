import java.util.Scanner;

/* 키보드로 정수 2자리 이내 값을 입력 받는다.
 * 1. 입력 받은 값이 80 ~ 90 사이이면 true, 아니면 false 출력
 * 2. 입력 받은 값이 80 ~ 90 사이이면서 35의 배수이면 true, 아니면 false 출력
 */
public class Exam_11 {
	public static void main(String[] args) {
		System.out.print("정수 입력 : ");
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		
		boolean bool = num>=80 && num<=90;
		System.out.println("80~90 : " + bool);
		
		boolean bool2 = num>=80 && num<=90 && num%35==0;
		System.out.println("80~90이고 35의 배수 : " + bool2);
		
		scn.close();

	}

}
