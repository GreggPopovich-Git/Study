// 키보드를 이용한 입력 Scanner 클래스 활용
import java.util.*;
public class Exam_05 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("이름입력 : ");
		String na = scn.next();
		System.out.print("국어점수 : ");
		int kor = scn.nextInt();
		System.out.print("영어점수 : ");
		int eng = scn.nextInt();
		System.out.print("수학점수 : ");
		int mat = scn.nextInt();
		
		int tot = kor + eng + mat;
		double ave = (double)tot/3;
		
		System.out.println("입력된 이름은 " + na + "입니다");
		System.out.println("총점은 " + tot + "입니다");
		System.out.println("평균은 " + ave + "입니다");
		scn.close();
	}

}
