import java.util.Scanner;

/* 키보드로 10진수를 입력 받아서 2, 8, 16진수로 변환 출력
 * [입력예시]
 * 10진수 입력 : 25
 * [출력예시]
 * 10진수 25는 2진수로 11001입니다.
 * 10진수 25는 8진수로 xxx입니다.
 * 10진수 25는 16진수로 xxx입니다.
 */
public class Exam_09 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("10진수 입력 : ");
		
		int Dec = scn.nextInt();
		
		String bin = Integer.toBinaryString(Dec);
		System.out.println("10진수 " + Dec + "는 2진수 : " + bin);
		String oct = Integer.toOctalString(Dec);
		System.out.println("10진수 " + Dec + "는 8진수 : " + oct);
		String hex = Integer.toHexString(Dec);
		System.out.println("10진수 " + Dec + "는 16진수 : " + hex);
		scn.close();

	}

}
