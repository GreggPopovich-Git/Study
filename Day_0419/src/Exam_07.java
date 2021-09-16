import java.util.Scanner;

class Cal {
	
	public void plus(int a, int b) {
		System.out.println("두 수의 합은 " + (a + b));
	}
	public void minus(int a, int b) {
		System.out.println("두 수의 차는 " + (a - b));
	}
	public void multiply(int a, int b) {
		System.out.println("두 수의 곱은 " + (a * b));
	}
	public void division(int a, int b) {
		if (b != 0)
			System.out.println("두 수를 나눴을 때의 몫은 " + (a / b));
		else
			System.out.println("0으로 나눌 수 없습니다.");
	}
	public void remainder(int a, int b) {
		if (b != 0)
			System.out.println("두 수를 나눴을 때의 나머지는 " + (a % b));
		else
			System.out.println("0으로 나눌 수 없습니다.");
	}
	public void fourrule(int a, String b, int c) {
		if (b.equals("+"))
			System.out.println("두 수의 합은 : " + (a + c));
		else if (b.equals("-"))
			System.out.println("두 수의 차는 : " + (a - c));
		else if (b.equals("*"))
			System.out.println("두 수의 곱은 : " + (a * c));
		else if (b.equals("/")) {
			if (c != 0)
				System.out.println("두 수를 나눴을 때의 몫은 " + (a / c));
			else
				System.out.println("0으로 나눌 수 없습니다.");
		}
		else if (b.equals("%")) {
			if (c != 0)
				System.out.println("두 수를 나눴을 때의 나머지는 " + (a % c));
			else
				System.out.println("0으로 나눌 수 없습니다.");
		}
		else
			System.out.println("잘 못 입력하셨습니다.");
	}
}
public class Exam_07 {
	public static void main(String[] args) {
		// 사칙연산을 수행하는 클래스 생성
		// 1. + (1+2),(2+1)
		// 2. - (1-2),(2-1)
		// 3. * (1*2),(2*1)
		// 4. / (1/2),(2/1), (1/0 -> 오류)
		// 5. % (1%2),(2%1), (1%0 -> 오류)
		Scanner scn = new Scanner(System.in);
		System.out.print("두개의 수를 입력하세요 : ");
		int a = scn.nextInt();
		int b = scn.nextInt();
/*		if (b == 0) {
			for (;;) {
				System.out.print("0으로 나눌수 없습니다. 다시 입력하세요 : ");
				b = scn.nextInt();
				if (b != 0)
					break;
			}
		}*/
		Cal go = new Cal();
		go.plus(a, b);
		go.minus(a, b);
		go.multiply(a, b);
		go.division(a, b);
		go.remainder(a, b);
		
		System.out.print("수행할 사칙연산을 입력하세요 : ");
		int c = scn.nextInt();
		String d = scn.next();
		int e = scn.nextInt();
		
		go.fourrule(c, d, e);
		scn.close();
	}
}