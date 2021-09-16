import java.util.Scanner;

// 키보드로 정수 데이터가 무작위로 입력될 때 짝수데이터의 합과 평균을 구하여 출력
// 단, 입력자료의 끝은 -99 이다
// 예시
// 입력 : 5 4 7 50 44 33 21 23 45 -99
// 짝수합 : xxx
// 짝수평균 : xx.xx
public class Exam_05 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int cnt = 0;
		int sum = 0;
		
		while (true) {
			System.out.print("정수 입력 : ");
			int a = scn.nextInt();
			if (a == -99) {
				break;
			}
			if (a%2 == 0) {
				cnt++;
				sum += a;
			}
			
		}
		double ave = (int)(sum/(double)cnt*100+0.5)/100.;
		System.out.println("짝수합 : " + sum);
		System.out.println("짝수평균 : " + ave);

		scn.close();
	}

}
