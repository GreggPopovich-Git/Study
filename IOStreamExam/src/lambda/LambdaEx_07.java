package lambda;

import java.util.Scanner;

@FunctionalInterface
interface MaxScore {
	public int maxScore(int[] score);
}
public class LambdaEx_07 {
	public static void main(String[] args) {
		// 키보드로 7개의 정수를 입력 받아서
		// 최대값을 찾아서 출력하는 프로그램 작성
		int[] score = new int[7];
		// 데이터 입력
		Scanner scn = new Scanner(System.in);
		System.out.print("7개의 정수 입력 : ");
		for(int x = 0; x < score.length; x++) {
			score[x] = scn.nextInt();
		}
		//람다식 정의 및 호출
		MaxScore ms = null;
		ms = (a) -> {
			int max = a[0];
			for (int x = 1; x < a.length; x++) {
				max = max > a[x] ? max : a[x];
			}
			return max;
		};
		System.out.println("입력한 수의 최대 값은 : " + ms.maxScore(score));
		scn.close();
	}

}