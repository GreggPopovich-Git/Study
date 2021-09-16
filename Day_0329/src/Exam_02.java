import java.util.Scanner;

// 키보드로 국어, 영어, 수학점수를 입력 받아서 평균이 80이상 "합격"
// 아니면 "불합격" 출력
public class Exam_02 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("국어, 영어, 수학 점수 입력 : ");
		int kor = scn.nextInt();
		int eng = scn.nextInt();
		int mat = scn.nextInt();
		double ave = (kor + eng + mat) / 3;
		
		if (ave >= 80) {
			System.out.println("합격");
		}
		else {
			System.out.println("불합격");
		}
		scn.close();
	}

}
