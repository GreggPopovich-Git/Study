import java.util.Scanner;

/* 학생수 5명 (학생당 항목은 번호, 국어, 영어, 수학, 전산) 입력 받아서
 * 다음과 같이 출력
 * [입력 형식]
 * 등록 : 1 90 70 90 80
 * 등록 : 5 95 75 95 85
 * . . . . . . . . . .
 * [출력형식]
 * 번호 국어 영어 수학 전산 총점 평균
 * 
 */
public class Exam_04 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int student[][] = new int[5][6];
		//입력 작업
		for (int x = 0; x < 5; x++) {
			System.out.print("등록 : ");
			student[x][0] = scn.nextInt();
			student[x][1] = scn.nextInt();
			student[x][2] = scn.nextInt();
			student[x][3] = scn.nextInt();
			student[x][4] = scn.nextInt();
			student[x][5] = student[x][1] + student[x][2] + student[x][3] + student[x][4];
		}
		//계산 작업
		
		//총점을 기준으로 오름차순

		for (int x = 0; x < student.length; x++) {
			for (int y = x + 1; y < student.length; y++) {
				if (student[x][5] > student[y][5]) {
					for (int k = 0; k < student[x].length; k++) {
						int temp = student[x][k];
						student[x][k] = student[y][k];
						student[y][k] = temp;
					}
				}
			}
		}

		//출력 작업
		System.out.println("번호\t국어\t영어\t수학\t전산\t총점\t평균");
		for (int x = 0; x < student.length; x++) {
/*			System.out.print(student[x][0] + "\t");
			System.out.print(student[x][1] + "\t");
			System.out.print(student[x][2] + "\t");
			System.out.print(student[x][3] + "\t");
			System.out.print(student[x][4] + "\t");
			System.out.print(student[x][5] + "\t");
			double ave = student[x][5]/3.;
			System.out.print(ave + "\n");
*/
			for (int y = 0; y < student[x].length; y++) {
				System.out.print(student[x][y] + "\t");
			}
			//평균
			double ave = (int)(student[x][5]/4. * 100 + 0.5)/100.;
			
			System.out.println(ave);
		}
		scn.close();
		
	}

}
