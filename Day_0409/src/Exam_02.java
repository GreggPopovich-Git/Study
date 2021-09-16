import java.util.Scanner;

public class Exam_02 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int student[][] = new int[6][6];
		
		//입력부분
		for (int x = 0; x < student.length-1; x++) {
			System.out.print("학생 등록 : ");
			for (int y = 0; y < student[x].length-2; y++) {
/*				switch (y) {
				case 0:
					System.out.print("번호 입력 : ");
					break;
				case 1:
					System.out.print("국어 점수 입력 : ");
					break;
				case 2:
					System.out.print("영어 점수 입력 : ");
					break;
				case 3:
					System.out.print("수학 점수 입력 : ");
					break;
				}  */
				student[x][y] = scn.nextInt();
				if (y != 0)
					student[5][y] += student[x][y];
				if (y != 0)
					student[x][4] += student[x][y];
				student[5][4] += student[x][y];
			}
		}
		//석차계산
		for (int i = 0; i < student.length-1; i++) {
			student[i][5] = 1;
			for (int j = 0; j < student.length-1; j++) {
				if (student[i][4] < student[j][4]) {
					student[i][5]++;
				}
			}
		}
		//출력부분
		System.out.println("번호\t국어\t영어\t수학\t총점\t석차");
		for (int x = 0; x < student.length; x++) {
			for (int y = 0; y < student[x].length; y++) {
				if (x == 5 && y ==0)
					System.out.print("합계\t");
				else if (student[x][y] == 0)
					System.out.print("");
				else
					System.out.print(student[x][y] + "\t");
			}
			System.out.println();
		}
		scn.close();

	}

}
