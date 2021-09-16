import java.util.Scanner;

// 키보드로 10개의 데이터를 입력 합(총점), 평균 출력
public class Exam_03 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int cnt = 0;
		int sum = 0;
/*		
		while (cnt<10) {
			System.out.print("점수 : ");
			int a = scn.nextInt();
			sum += a;
			cnt++;
		}
*/
/*
		do {
			System.out.print("점수 : ");
			int a = scn.nextInt();
			sum += a;
			cnt++;
		}while (cnt<10);
*/
		while (true) {
			System.out.print("점수 : ");
			int a = scn.nextInt();
			sum += a;
			cnt++;
			if (cnt==10) {
				break;
			}
		}
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + sum/cnt);
		scn.close();
	}

}
