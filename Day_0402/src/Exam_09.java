import java.util.Scanner;

/* 키보드로 정수를 입력 받아서 소수만 출력하는 프로그램 작성
 * [입력형식]
 * 정수 : 2 5 10 59 31 27 53 71 -99
 * 소수 : 
 * 전체 입력 자료수 : 
 * 소수 갯수 : 
 */
public class Exam_09 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a;
		int x;
		int totcnt = 0;
		int cnt = 0;
		System.out.print("정수 입력 : ");
		while (true) {
			a = scn.nextInt();
			if (a == -99)
				break;
			totcnt++;
			for (x = 2; x <= a; x++) {
				if (a % x == 0) {
					if (a == x) {
						System.out.print(a + "\t");
						cnt++;
						break;
					}
					break;
				}
			}
		}
		System.out.println("\n전체 입력 자료 수 : " + totcnt);
		System.out.println("소수 갯수 : " + cnt);
	}

}