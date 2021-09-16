import java.util.Scanner;

// 정수 3개 입력 가장 큰 값 찾기
// 예) 입력 : 15 9 20
// 입력 자료 : 15 9 20
// 최대값 : 20
public class Exam_06 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("정수 3개 입력 : ");
		int a = scn.nextInt();
		int b = scn.nextInt();
		int c = scn.nextInt();
		
		int x = (a>b) ? a : b;
		int y = (x>c) ? x : c;
		
		System.out.println("최대값 : " + y);
		
		scn.close();
	}

}
