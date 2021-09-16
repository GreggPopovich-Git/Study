import java.util.Scanner;

/* 키보드로 정수(M)를 입력 받아서 2부터 M까지 소수를 구하여 출력
 * [입력 예시]
 * 정수 : 50
 * [출력 예시]
 * 소수 출력
 * 2  3  5  7  11 
 * 13 17 23 .  .
 * .  .  .  .  .
 * 
 * 소수 개수 : xx
 * 
 * [처리 조건]
 * 1. 한 줄에 5개씩 출력
 * 2. 마지막에 소수의 총 개수 출력
 */
public class Exam_01 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int m = scn.nextInt();
		int i = 0;
		int j = 0;
		int cnt = 0;
		for (i = 2; i <= m; i++) {
			for (j = 2; j < i; j++) {
				if (i % j == 0)
					break;
			}
			if (i == j) {
				cnt++;
				System.out.print(i + "\t");
				if (cnt % 5 == 0)
					System.out.println();
			}
			
		}
		System.out.println("소수 개수 : " + cnt);
		scn.close();

	}

}
