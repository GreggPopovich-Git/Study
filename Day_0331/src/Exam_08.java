import java.util.Scanner;

/* 10진수를 입력 받아서 2진수로 변환출력을 하는 프로그램 작성
* 입력 값이 -99 이면 종료
* [입력예시]
* 10진수 : 25
* 10진수 25는 2진수 11001
* 
* 10진수 : 10
* 10진수 10은 2진수 1010
* 
* 10진수 : -99
* 
*/ 
public class Exam_08 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int mok;
		int a;
		while (true) {
			int nmg = 0;
			String bin = "";
			System.out.print("10진수 : ");
			a = scn.nextInt();
			int b = a;
			if (a == -99)
				break;
/*
			while(a != 0) {
				mok = a/2;
				nmg = a%2;
				bin = nmg + bin;
				a = mok;
				}
*/
			do {
				mok = a/2;
				nmg = a%2;
				bin = nmg + bin;
				a = mok;
			}while(a != 0);
			System.out.println("10진수 " + b + "는 2진수 " + bin);
		}
		System.out.println("프로그램을 종료합니다.");
		scn.close();
	}
		
}
