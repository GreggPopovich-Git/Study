import java.util.Scanner;

public class Exam_03 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[][] student = new int[100][3];
		//Data Input
		for (int i = 0; i < student.length; i++) {
			if (i > 1 && student[i-1][0] == 0)
				break;
			for (int j = 0; j < student[i].length; j++) {
				System.out.print("학생등록 : ");
				int a = scn.nextInt();
				if (a == 0)
					break;
				student[i][j] = a;
			}
		}
		//Sort
		for (int x = 0; x < student.length-1; x++) {
			for (int y = 0; y < student.length; y++) {
				if (student[x][0] != 0 && student[x][0] < student[y][0]) {
					for (int k = 0; k < student[x].length; k++) {
						int temp = student[x][k];
						student[x][k] = student[y][k];
						student[y][k] = temp;
					}
				}
			}
		}
		//max,min
		int max = student[0][2];
		int min = student[0][2];
		for (int i = 0; i < student.length; i++) {
			if (student[i][2] == 0)
				break;
			max = (max >= student[i][2]) ? max : student[i][2];
			min = (min <= student[i][2]) ? min : student[i][2];
		}
		//Data Output
		System.out.println("반\t번호\t체중");
		for (int i = 0; i < student.length; i++) {
			for (int j = 0; j < student[i].length; j++) {
				if (student[i][j] == 0)
					break;
				if (j == 0 && i != 0 && student[i][0] == student[i-1][0]) {
					j++;
					System.out.print("\t");
				}
				System.out.print(student[i][j] + "\t");
			}
			if (student[i][0] == 0)
				break;
			System.out.println();
		}
		System.out.println("최소체중 : " + min);
		System.out.println("최대체중 : " + max);
		scn.close();
	}
}