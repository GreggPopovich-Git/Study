import java.util.Scanner;
// 키보드로 점수를 입력 받아서 수, 우, 미, 양, 가 출력 
public class Exam_07 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("입력점수 : ");
		int score = scn.nextInt();
		
		switch (score/10) {
		case 10:
		case 9:
			System.out.println("수");
			break;
		case 8:
			System.out.println("우");
			break;
		case 7:
			System.out.println("미");
			break;
		case 6:
			System.out.println("양");
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
		case 0:
			System.out.println("가");
			break;
		default:
			System.out.print("입력 오류");
		}
		scn.close();
	}

}
