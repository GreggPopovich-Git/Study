// 키보드로 정수를 입력 받아서 소수인지 판별하는 프로그램
public class Exam_07 {
	public static void main(String[] args) {
		int num = 4;
		for (int x = 2; x <= num; x++) {
			if (num % x == 0) {
				if (num == x) {
					System.out.println(num + "는 소수");
					break;
				}
				System.out.println(num + "는 소수가 아님");
				break;
			}
		}
		
	}

}
