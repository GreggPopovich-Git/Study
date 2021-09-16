import java.util.Scanner;

/* 키보드로 1이상인 정수를 무한대 입력 받아서 최대, 최소 값을 뺀 나머지 합의 평균을 구하여 출력
 * [입력형식]
 * 입력 : 20 30 59 -9 0 44 39 -23 55 49 80 59 88 59 -99
 * 총데이터 입력 수 : 14
 * 오류데이터 수 : 3
 * 최대 : 88
 * 최소 : 20
 * 평균 : xx.x
 */
public class Exam_03 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int score;
		int cnt = 0;
		int cnt2 = 0;
		int tot = 0;
		int max = 0;
		int min = 0;
		boolean bool = true;
		System.out.print("정수 입력 : ");
		while(true) {
			score = scn.nextInt();
			if (score == -99)
				break;
			else if (score < 1) {
				cnt2++;
			}
			else {
				if (bool) {
					max = score;
					min = score;
					bool = false;
					cnt++;
					tot += score;
				}
				else {
					cnt++;
					tot += score;
					if (score > max)
						max = score;
					if (score < min)
						min = score;
				}
			}
		}
		double ave = (int)(tot/(double)cnt*100+0.5)/100.;
		System.out.println("총데이터 입력 수 : " + (cnt+cnt2));
		System.out.println("오류데이터 수 : " + cnt2);
		System.out.println("최대 : " + max);
		System.out.println("최소 : " + min);
		System.out.println("평균 : " + ave);
		scn.close();
	}

}
