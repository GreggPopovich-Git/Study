import java.util.Scanner;

public class Exam_05 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("정수 3개 입력 : ");
		int num = scn.nextInt();
		int a = scn.nextInt();
		int b = scn.nextInt();
		int tot = 0;
		if (num == 1) {
			tot = a + b;
		}
		else if (num == 2) {
			tot = a - b;
		}
		else if (num == 3) {
			tot = a * b;
		}
		else if (num == 4) {
			tot = a / b;
		}
		else if (num == 5){
			tot = a % b;
		}
		else {
			System.out.println("입력 오류");
		}
		System.out.println(tot);
		scn.close();

	}

}
