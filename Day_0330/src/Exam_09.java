import java.util.Scanner;

/* 키보드로 문자열을 입력 받아서 다음 조건에 맞게 출력하는 프로그램 작성
 * 1. 입력받은 값이 "blue"이면 다시 키보드로 "yes/no"를 입력 받아서 "yes"이면 "건너갑니다" 라는 문자열을 출력하고 "no"이면
 * "다음에 건너갑니다" 출력한다.
 * 2. 입력 받은 값이 "red"이면 "기다리세요" 라는 문자열을 출력한다.
 * 3. 입력 받은 "blue" or "red" 이외의 값이 입력되면 "입력오류입니다" 출력한다.
 */
public class Exam_09 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("문자열을 입력하시오 : ");
		String color = scn.next();
		String massage;
		if (color.equals("blue")) {
			System.out.print("건너갈까요(yes/no) : ");
			String judge = scn.next();
			if (judge.equalsIgnoreCase("yes")) {
				massage = "건너갑니다.";
			}
			else if(judge.equalsIgnoreCase("no")){
				massage = "다음에 건너갑니다.";
			}
			else {
				massage = "입력 오류입니다.";
			}
		}
		else if (color.equals("red")) {
			massage = "기다리세요.";
		}
		else {
			massage = "입력 오류입니다.";
		}
		System.out.println(massage);
		scn.close();
	}

}
