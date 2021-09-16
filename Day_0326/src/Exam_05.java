import java.util.Scanner;

/* 10진수 2개 입력 + 하는 P/G
* ex) 10진수 : 7 8
* [결과]
*   101
* + 100
* -----
*  1001
*/
public class Exam_05 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("10진수 두개 입력 : ");
		int a = scn.nextInt();
		int b = scn.nextInt();
		int c = a + b;
		
		String str1 = Integer.toBinaryString(a);
		String str2 = Integer.toBinaryString(b);
		String str3 = Integer.toBinaryString(c);
		System.out.println("\t" + str1);
		System.out.println("+\t" + str2);
		System.out.println("-------------");
		System.out.println("\t" + str3);
		
		scn.close();
	}

}
