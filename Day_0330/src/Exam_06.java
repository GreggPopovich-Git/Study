import java.util.Scanner;

public class Exam_06 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("정수 3개 입력 : ");
		int num = scn.nextInt();
		int a = scn.nextInt();
		int b = scn.nextInt();
		int tot = 0;
		
		switch (num) {
		case 1:
			tot = a + b;
			break;
		case 2:
			tot = a - b;
			break;
		case 3:
			tot = a * b;
			break;
		case 4:
			tot = a / b;
			break;
		case 5:
			tot = a % b;
			break;
		default:
			System.out.println("입력오류");
		}
		System.out.println(tot);
		scn.close();
	}

}
