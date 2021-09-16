import java.util.Scanner;

/* 키보드로 정수(최대 1000) 입력 받아서 2진수로 변환 출력하는 프로그램
 * int 형 배열 10개 선언 후 배열에 2진수 기억 후 출력
 * [입력형식]
 * 정수 : 25
 * 2진수 : 11001
 * 정수 : 1001
 * 입력오류
 * 정수 : -99  ->프로그램 종료
 */
public class Exam_07 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int bin[];
		int i = 0;
		while (true) {
			bin = new int[10];
			System.out.print("정수 : ");
			int num = scn.nextInt();
			if (num == -99) {
				break;
			}
			if (num > 1000) {
				System.out.println("입력오류");
				continue;
			}
			//2진수 변환
			i = 0;
			while (true) {	
				bin[i] = num % 2;
				num /= 2;
				i++;
				if (num == 0)
					break;
			}
			System.out.print("2진수 : ");
			while (true) {
				i--;
				System.out.print(bin[i]);
				if (i == 0)
					break;
			}
			System.out.println();
			scn.close();
		}
		
	}

}
