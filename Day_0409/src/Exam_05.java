import java.util.Scanner;

/* [입력형식] 번호 국어 영어 수학
 * 입력 : 1 90 88 77
 * .   .   .   .   .
 * 입력 : 0 - > 입력종료
 * 
 * [출력형식]
 * 	번호	총점	평균	 그 래 프
 *   1  240 80  ***************
 *   3  235 75  **************
 *   	.    .    .    .    .
 *   
 * [처리조건]
 * 1. 학생은 최대 10명
 * 2. 평균은 정수만(소수이하 첫째자리에서 반올림)
 * 3. 그래프는 평균점에 따라 출력하되 5점당 '*' 1개 출력
 * 4. 출력순서는 총점이 가장 높은 학생부터 출력한다.
 */
public class Exam_05 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int student[][] = new int[10][6];
		//Data 입력, 총점 계산, 평균 계산
		for (int x = 0; x < student.length; x++) {
			System.out.print("데이터 입력 : ");
			for (int y = 0; y < student[x].length-2; y++) {
				student[x][y] = scn.nextInt();
				if (student[x][y] == 0)
					break;
				student[x][4] += student[x][y]; //총점
				student[x][5] = (int)((student[x][4])/3.*10+0.5)/10; //평균
			}
			if (student[x][0] == 0)
				break;
		}
		//Sort
		for (int x = 0; x < student.length; x++) {
			for (int y = x+1; y < student.length; y++) {
				if (student[x][4] < student[y][4]) {
					for (int k = 0; k < student[x].length; k++) {
						int temp = student[x][k];
						student[x][k] = student[y][k];
						student[y][k] = temp;
					}
				}
			}
		}
		//Graph
		String star[] = new String[10];
		for (int x = 0; x < student.length; x++) {
			star[x] = "";
			for (int y = 0; y < student[x][5]/5; y++) {
				star[x] += "*";
			}
		}
		//Data 출력
		System.out.println("번호\t총점\t평균\t\t그래프");
		for (int x = 0; x < student.length; x++) {
			for (int y = 0; y < student[x].length; y++) {
				if (student[x][y] == 0)
					System.out.print("\t");
				else if (y == 0 || y == 4 || y == 5)
					System.out.print(student[x][y] + "\t");
			}
			System.out.println(star[x]);
		}
		scn.close();
	}
}