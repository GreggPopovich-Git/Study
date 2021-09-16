import java.util.Scanner;

/* 키보드로 이름, 국어, 영어, 수학 점수를 입력 받아서 총점, 평균을
 * 구하여 다음과 같이 출력
 * [ 출력 예시 ]
 * 이름       국어    영어    수학    총점    평균
 * 홍길동	 90   80  70  240 84.4
 */
public class Exam_03 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("입력 : ");
		String name = scn.next();
		int kor = scn.nextInt();
		int eng = scn.nextInt();
		int mat = scn.nextInt();
		
		int tot = kor + eng + mat;
		double ave = tot/3.0;
		
		System.out.println("이름    국어    영어    수학    총점    평균");
		System.out.print(name + "  " + kor + "  " + eng + "  ");
		System.out.println(mat + "  " + tot + "  " + ave + "  ");
		
		System.out.println("-----------------------------------------");
		
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + ave);
		scn.close();
	}

}
