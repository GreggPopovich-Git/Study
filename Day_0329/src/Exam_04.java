import java.util.Scanner;

public class Exam_04 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("String Data : ");
		String a1 = scn.nextLine();
		String a2 = scn.next();// nextLine 은 한줄을 통째로 입력 받음. next 는 공백이나 엔터를 기준으로 구분해서 입력 받을 수 있음.
		System.out.print("a1 = " + a1);
		System.out.print("a2 = " + a2);
		scn.close();
	}

}
