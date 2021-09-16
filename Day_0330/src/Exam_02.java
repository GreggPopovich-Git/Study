import java.util.Scanner;

/* 키보드로 이름, 국어, 영어, 수학 입력 받아서 이름, 총점, 평균, 판정을 출력
 * [입력 예시]
 * 입력 자료 : 홍길동 39 90 80
 * [출력 예시]
 * 이름 : 홍길동
 * 평균 : 69
 * 판정 : 불합격
 * 불합격 사유 : 과락
 * [처리 조건]
 * 1. 조건 : 3과목 점수가 40이상 평균 60이상 합격
 * 2. 평균 60미만 -> 불합격, 이유 : 평균 미만
 * 3. 1과목이라도 40 미만이 있는 경우 -> 불합격, 이유 : 과락
 * 4. 판정이 '불합격'일 경우 불합격사유를 출력한다.
 */
public class Exam_02 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("입력 자료 : ");
		String name = scn.next();
		int kor = scn.nextInt();
		int eng = scn.nextInt();
		int mat = scn.nextInt();
		
		int tot = kor + eng + mat;
		double ave = (int)(tot/3.*100+0.5)/100.;
		
		String judge = "합격";
		String reason = "";
		
		if (kor<40 || eng<40 || mat<40) {
			judge = "불합격";
			reason = "과락";
		}
		else if (ave<60) {
			judge = "불합격";
			reason = "평균 미만";
		}
		System.out.println("이름 : " + name + "\n평균 : " + ave + "\n판정 : " + judge);
		if (judge.equals("불합격")) {
			System.out.print("불합격 사유 : " + reason);
		}
		scn.close();
	}

}
