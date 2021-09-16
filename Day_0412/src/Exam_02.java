import java.util.Scanner;

public class Exam_02 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int number = 0;
		int age = 0;
		int data[][] = new int[11][9];
		//Data Input, Calculation
		while(true) {
			System.out.print("등록 : ");
			number = scn.nextInt();
			if (number == 0)
				break;
			scn.next();
			age = scn.nextInt();
			if (age >= 70)
				age = 60;
			data[number-1][age/10+1]++;
			data[number-1][8]++;
			data[10][age/10+1]++;
			data[10][8]++;
		}
		for (int i = 0; i < data.length-1; i++)
			data[i][0] = i + 1;
		//Data Output
		System.out.println("동\t0~9\t10~19\t20~29\t30~39\t40~49\t50~59\t60이상\t합계");
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (i == 10 && j == 0)
					System.out.print("합계\t");
				else
					System.out.print(" " + data[i][j] + "\t");
			}
			System.out.println();
		}
		scn.close();
	}
}