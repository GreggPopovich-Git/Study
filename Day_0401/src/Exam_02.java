import java.util.Scanner;

/* 키보드로 점수 (1~100) 7개를 입력 받아서 최대, 최소값을 제외한 합을 구하여 출력
 * 점수가 (1~100) 이외의 값 입력시 "점수오류" 출력하고 재입력 한다.
 * [입력 예시]
 * 점수입력 : 90
 * 점수입력 : -9
 * 입력오류
 * 점수입력 : 66
 * 점수입력 : 78
 * 점수입력 : 55
 * 점수입력 : 95
 * 점수입력 : 88
 * 점수입력 : 77
 * 최대점수 : 95
 * 최소점수 : 55
 * 합계(최대-최소)점수 : 399
 */
public class Exam_02 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int i = 0;
		int tot = 0;
		int max = -999;
		int min = 999;
		while (i!=7) {
			System.out.print("점수입력 : ");
			int score = scn.nextInt();
			if (score < 0 || score > 100) {
				System.out.println("입력오류");
			}
			else {
				tot += score;
				i++;
				if (score > max)
					max = score;
				if (score < min)
					min = score;
			}
		}
		tot = tot - max - min;
		System.out.println("최대점수 : " + max);
		System.out.println("최소점수 : " + min);
		System.out.println("합계(최대-최소) : " + tot);
		scn.close();
	}

}
