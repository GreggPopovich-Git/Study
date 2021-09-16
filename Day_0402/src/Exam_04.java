/* 1 ~ 100 사이의 정수 중 홀수 합, 짝수 합을 계산 출력
 * [출력형식]
 * 1~100 홀수 합 : 2500
 * 1~100 짝수 합 : 2550
 */
public class Exam_04 {
	public static void main(String[] args) {
		int i;
		int sum1 = 0;
		int sum2 = 0;
		boolean bool = true;
		for (i = 1; i<101; i++) {
			if (bool) {
				sum1 += i;
				bool = false;
			}
			else {
				sum2 += i;
				bool = true;
			}
		}
		System.out.println("1~100 홀수 합 : " + sum1);
		System.out.println("1~100 짝수 합 : " + sum2);

	}

}