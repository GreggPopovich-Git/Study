import java.util.*;

// 10진수를 입력 받아서, 8진수 16진수로 변환
public class Exam_06 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("10진수 입력 : ");
		int a = scn.nextInt();
		System.out.printf("10진수 (%d)는 8진수 (%o)입니다.\n", a, a);
		System.out.printf("%d %x %X\n", a, a, a);
		
		System.out.printf("%d %c\n", (int)'A', 65);
		scn.close();
	}

}
