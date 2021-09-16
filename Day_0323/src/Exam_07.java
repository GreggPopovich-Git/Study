import java.util.Scanner;

// 산술 연산자
// 키보드로 정수 2개 입력 사칙연산
public class Exam_07 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("정수1 : ");
		int a = scn.nextInt();
		System.out.print("정수2 : ");
		int b = scn.nextInt();
		
		System.out.println(a + "+" + b + "="+ (a+b));
		System.out.println(a + "-" + b + "="+ (a-b));
		System.out.println(a + "*" + b + "="+ (a*b));
		System.out.println(a + "/" + b + "="+ (a/b));
		System.out.println(a + "%" + b + "="+ (a%b));
		scn.close();
	}

}
