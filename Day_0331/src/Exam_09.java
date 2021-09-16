import java.util.Scanner;

/* 10진수를 입력 받아서 2진수로 변환출력을 하는 프로그램 작성
* 입력 값이 -99 이면 종료
* [입력예시]
* 10진수 : 25
* 10진수 25는 2진수 11001
* 
* 10진수 : 10
* 10진수 10은 2진수 1010
* 
* 10진수 : -99
* 
*/ 
public class Exam_09 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int mok;
		String a;
		String c;
		while (true) {
			int nmg = 0;
			String bin = "";
			System.out.print("10진수 : ");
			a = scn.nextLine();
			if (a.equals("-99"))
				break;
			System.out.print("진수 : ");
			c = scn.nextLine();
			while (!(c.equals("2") || c.equals("16") || c.equals("8"))) {
				System.out.print("진수를 다시 입력하세요 : ");
				c = scn.nextLine();
				if (a.equals("-99"))
						break;
			}
			int d = Integer.parseInt(c);
			int b = Integer.parseInt(a);
			if (b == -99)
				break;
			do {
				String str = "";
				if (b%d > 9) {
					switch (b%d) {
					case 10:
						str = "A";
						break;
					case 11:
						str = "B";
						break;
					case 12:
						str = "C";
						break;
					case 13:
						str = "D";
						break;
					case 14:
						str = "E";
						break;
					case 15:
						str = "F";
						break;
					}
					mok = b/d;
					nmg = b%d;
					bin = str + bin;
					b = mok;
				}
				else {
				mok = b/d;
				nmg = b%d;
				bin = nmg + bin;
				b = mok;
				}
			}while(mok != 0);
			System.out.println("10진수 " + a + "는 " + c + "진수 " + bin);
		}
		System.out.println("프로그램을 종료합니다.");
		scn.close();
	}
		
}
