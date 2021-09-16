import java.util.Scanner;

// 키보드로 점수를 입력 받아서 총점, 평균을 구하여 출력
// 입력자료가 -99이면 입력자료의 끝
public class Exam_04 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int cnt = 0;
		int sum = 0;

		System.out.println("점수 입력 : ");
		while (true) {
			int a = scn.nextInt();
			if (a==-99) {
				break;
			}
			cnt++;
			sum += a;
		}
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + sum/cnt);
		System.out.println("---------------------------------------");
		int b;
		int cnt2 = 0;
		int sum2 = 0;
		while ((b=scn.nextInt()) != -99) {
			cnt2++;
			sum2 += b;
		}
		System.out.println("합계 : " + sum2);
		System.out.println("평균 : " + sum2/cnt2);
		
		scn.close();
	}

}
