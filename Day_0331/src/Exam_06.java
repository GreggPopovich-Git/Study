import java.util.Scanner;

// 임의의 데이터 중 최대, 최소
public class Exam_06 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int max = -999;
		int min = 999;
		System.out.print("입력 : ");
		while(true) {
			int a = scn.nextInt();
			if (a == -99)
				break;
			if (max < a)
				max = a;
			if (min > a)
				min = a;
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
		scn.close();
	}

}
