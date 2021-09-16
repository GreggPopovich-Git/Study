package lambda;

import java.util.Scanner;

@FunctionalInterface
interface MySum {
	public int add(int x, int y);
}
// 키보드로 x, y를 입력 받아서 x ~ y 사이의 소수의 개수를 구하여 출력
public class LambdaEx_06 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("두개의 수 입력 : ");
		int a = scn.nextInt();
		int b = scn.nextInt();
		MySum ms = null;
		ms = (x, y) -> {
			int cnt = 0;
			for(int i = x; i <= y; i++) {
				int j;
				for(j = 2; j <= i; j++) {
					if (i % j == 0) {
						break;
					}
				}
				if (i == j)
					cnt++;
			}
			return cnt;
		};
		System.out.println(a + " ~ " + b + "사이의 소수의 개수 : " + ms.add(a, b));
		scn.close();
	}

}
