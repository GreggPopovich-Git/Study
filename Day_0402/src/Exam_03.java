/* 1 ~ 100 사이의 정수 중 홀수 합, 짝수 합을 계산 출력
 * [출력형식]
 * 1~100 홀수 합 : 2500
 * 1~100 짝수 합 : 2550
 */
public class Exam_03 {
	public static void main(String[] args) {
		int i;
		int sum1 = 0;
		int sum2 = 0;
		
		for (i = 1; i<101; i++) {
			if (i%2==1) {
				sum1 += i;
			}
			else {
				sum2 += i;
			}
		}
		System.out.println("1~100 홀수 합 : " + sum1);
		System.out.println("1~100 짝수 합 : " + sum2);

	}

}