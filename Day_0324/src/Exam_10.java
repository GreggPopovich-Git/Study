import java.util.Scanner;

/* 키보드로 2, 8, 16진수를 입력 받아서 10진수로 변환 출력
 * [입력예시]
 * 입력 : 11001 2
 * [출력예시]
 * 2진수 11001은 10진수로 25입니다.
 * 
 * [입력예시]
 * 입력 : 5b 16
 * [출력예시]
 * 16진수 5b은 10진수로 91입니다.
 */
public class Exam_10 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("입력 : ");
		
		String a = scn.next();
		int b = scn.nextInt();
		
		int Dec = Integer.parseInt(a, b);
		
		System.out.println(b + "진수 " + a + "는 10진수 " + Dec + "입니다.");
		
		scn.close();
	}

}
