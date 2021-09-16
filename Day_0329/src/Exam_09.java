import java.util.Scanner;

/*	키보드로 정수 3개 입력 다음과 같이 출력되는 프로그램 작성
 * [입력예시]
 * 정수입력 : 7 9 5
 * MAX = 9, MED = 7, MIN = 5
 * 
 * 정수입력 : 7 7 9
 * 입력오류
 * 
 * 1. 세개의 정수 중 동일한 값이 존재하면 "입력오류" 출력
 * 
 */
public class Exam_09 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("정수3개 입력 : ");
		int a = scn.nextInt();
		int b = scn.nextInt();
		int c = scn.nextInt();
		
		int max = 0;
		int med = 0;
		int min = 0;

		if (a == b || a == c || b == c) {
			System.out.println("입력오류");
		}
		else if (a > b) {
			if (a > c) {
				max = a;
				if (b > c) {
					med = b;
					min = c;
				}
				else {
					med = c;
					min = b;
				}
				
			}
			else {
				max = c;
				med = a;
				min = b;
			}
		}
		else {
			if (b > c) {
				max = b;
				if (a > c) {
					med = a;
					min = c;
				}
				else {
					med = c;
					min = a;
				}
			}
			else {
				max = c;
				med = b;
				min = a;
			}
		}
		System.out.println("MAX = " + max + "\tMED = " + med + "\tMIN = " + min);
		scn.close();
	}

}
