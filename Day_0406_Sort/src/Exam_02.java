import java.util.Scanner;

/* 정수배열 10개가 선언되었을 경우 키보드로 0이상 100이하의 데이터를 배열에 등록 후 출력
 * 
 */
public class Exam_02 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int score[] = new int[10];
/*		for (int x = 0; x < 10; x++) {
			System.out.print("등록 : ");
			int a = scn.nextInt();
			if (a < 0 || a > 100) {
				x--;
				continue;
			}
			score[x] = a;
		}
		*/
		int cnt = 0;
		while (cnt < 10) {
			System.out.print("등록 : ");
			int a = scn.nextInt();
			if (a < 0 || a > 100) {
				continue;
			}
			score[cnt] = a;
			cnt++;
		}
		//출력부분
		System.out.print("입력자료 : ");
		for (int x = 0; x < 10; x++) {
			System.out.print(score[x] + "  ");
		}
		scn.close();
	}
}