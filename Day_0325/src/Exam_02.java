import java.util.Scanner;

/* 키보드로 번호, 이름, 국어, 영어, 수학 점수를 입력 받아서 총점, 평균을 구하여 다음과 같이 출력
 * [입력형식]
 * 등록 : 1  홍학생  95 88 73
 * [출력형식]
 * 번호   이름   국어   영어   수학   총점   평균
 *  1  홍학생 95  88  73 256 85.3333
 */
public class Exam_02 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("입력 : ");
		int num = scn.nextInt();
		String name = scn.next();
		int kor = scn.nextInt();
		int eng = scn.nextInt();
		int mat = scn.nextInt();
		
		int tot = kor + eng + mat;
		double ave = (int)(tot / 3.0 * 100 + 0.5) / 100.0;
		
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(num + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + ave);
		
		scn.close();
	}

}
