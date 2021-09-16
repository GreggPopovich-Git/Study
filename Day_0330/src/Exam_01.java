import java.util.Scanner;

public class Exam_01 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		int c = scn.nextInt();
		
		if (!(a==b || a==c || b==c)) {
			if (a<b) {
				int t = a;
				a=b;
				b=t;
			}
			if (a<c) {
				int t=a;
				a=c;
				c=t;		
			}
			if (b<c) {
				int t=b;
				b=c;
				c=t;
			}
			System.out.println("MAX = " + a + "\tMED = " + b + "\tMIN = " + c);
		}
		else {
			System.out.println("입력오류");
		}
		scn.close();
	}

}
