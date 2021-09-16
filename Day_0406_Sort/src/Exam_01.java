import java.util.Scanner;

/* 키보드로 10진수 입력 2, 8, 16 진수로 변환
 * 1. 입력 값이 0이면 종료한다.
 * [입력예시]
 * 	10진수 : 10
 * 	진수 : 2
 * 	2진수 : 1010
 */
public class Exam_01 {
	public static void main(String[] args) {
		char pri[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		String str = "";
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.print("정수 : ");
			int val = scn.nextInt();
			if (val == 0)
				break;
			System.out.print("변환 수 : ");
			int num = scn.nextInt();
			do {
				int mok = val / num;
				int na = val % num;
				str = pri[na] + str;
				val = mok;
			}while (val != 0);
		System.out.println(str);
		}
		scn.close();
		
	}

}
