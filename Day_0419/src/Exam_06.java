class FF {
	// 1. 정수 3개를 받아서 최대값을 리턴하는 메소드
	public int scoreMax(int a, int b, int c) {
		int max;
		max = (a > b) ? a : b;
		max = (max > c) ? max : c;
		return max;
	}
	// 2. n개의 정수를 받아서 입력 받은 정수를 모두 출력하고 마지막에 최대값, 최소값을 출력하는 메소드
	public void scoreMax(int ... a) {
		int max = a[0];
		int min = a[0];
		for (int x = 0; x < a.length; x++) {
			System.out.print(a[x] + " ");
			max = (max > a[x]) ? max : a[x];
			min = (min < a[x]) ? min : a[x];
		}
		System.out.println("\n최대값 : " + max + "\n최소값 : " + min);
	}
	// 3. 2 ~ n 까지 소수를 출력하는 메소드 (한줄에 5개씩 출력) 마지막에 소수의 개수를 반환
	public int priScore(int a) {
		int cnt = 0;
		for (int x = 2; x <= a; x++) {
			for (int y = 2; y <= a; y++) {
				if (x % y == 0) {
					if (x == y) {
						System.out.print(x + "\t");
						cnt++;
						if (cnt % 5 == 0)
							System.out.println();	
					}
					break;
				}
			}	
		}
		return cnt;
	}
}
public class Exam_06 {
	public static void main(String[] args) {
		FF ff = new FF();
		int max = ff.scoreMax(7, 5, 8);
		System.out.println("세 수 : 7, 5, 8의 최대 값 : " + max);
		ff.scoreMax(7, 9, 24, 10, 55, 77, 45, 34, 90, 65);
		int n = 50;
		int cnt = ff.priScore(n);
		System.out.println("2~" + n + "까지 소수는 " + cnt);
	}
}