import java.util.Scanner;

// 정수 3개 최소값 찾기
public class Exam_07 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("정수 3개 입력 : ");
		int a = scn.nextInt();
		int b = scn.nextInt();
		int c = scn.nextInt();
		
		int x = (a<b) ? a : b;
		int y = (x<c) ? x : c;
		
		System.out.println("최소값 : " + y);
		
		scn.close();
	}

}
