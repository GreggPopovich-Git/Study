// import -> java API 를 포함시킬 때 사용.
import java.util.Scanner;

public class Exam_04 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		BB b1 = BB.getInstance(); // 같은 패키지 안에 있는 클래스는 사용할 수 있음.
		System.out.println(b1);
		AA a1 = new AA();
		System.out.println(a1);
		
		scn.close();
	}

}
