import java.util.Scanner;

/* 키보드로 정수 10개를 입력 받아서 합과 평균을 구하여 출력
 * 단, 입력 자료에 1미만의 자료는 제외한다.
 * [입력예시]
 * 점수 : 90 70 80 -99 90 70 0 88 76 54 32 -77 7 65 6 5 5 4 3
 */
public class Exam_05 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("10개의 정수 입력 : ");
		int a = 0;
		int sum = 0;
		int cnt = 0;
/*
		while (cnt<10) {
			a = scn.nextInt();
			if (a < 1)
				continue;
			cnt++;
			sum += a;
		}
*/
/*
		do {
			a = scn.nextInt();
			if (a < 1)
				continue;
			cnt++;
			sum += a;
		}while(cnt<10);
*/

		for (cnt = 1; cnt <= 10; cnt++) {
			a = scn.nextInt();
			if (a > 0)
			sum += a;
			else
				cnt--;
		}

		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + sum/(cnt-1));
		scn.close();
	}

}
