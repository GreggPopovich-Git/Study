import java.util.Scanner;

// 키보드로 이름, 국어, 영어, 수학 입력 총점, 평균을 구하여 출력
// 입력 : aaa 65 77 88
public class Exam_06 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("입력 : ");
		String na = s.next();
		int k = s.nextInt();
		int e = s.nextInt();
		int m = s.nextInt();
		
		int tot = k + e + m;
		double ave = (double)tot/3;
		
		System.out.println("이름 : " + na);
		System.out.println("총점 : " + tot);
		System.out.println("평균 : " + ave);
		s.close();
	}

}
