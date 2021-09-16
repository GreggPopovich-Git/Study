package iostream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/* 키보드로 번호, 이름, 국어, 영어, 수학 입력 총점, 평균을 구하여 'dataout.txt' 파일로 출력
 * [입력형식]
 * 입력 : 1, 김학생, 90, 99, 88
 * . . . . . . . . . . . . .
 * 입력 : 0  ->  출력
 * [출력형식]
 * 번호	이름	국어	영어	수학	총점	평균
 * .  .  .  .  .  .  .  .  .  .
 */
public class FileOutput_01 {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		File file = new File("dataout.txt");
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		pw.println("번호\t이름\t\t국어\t영어\t수학\t총점\t평균");
		while (true) {
			System.out.print("학생정보 입력 : ");
			String[] str = scn.nextLine().split(",");
			if (str[0].equalsIgnoreCase("0")) {
				System.out.println("입력종료");
				break;
			}
			int tot = Integer.parseInt(str[2]) + Integer.parseInt(str[3]) + Integer.parseInt(str[4]);
			double ave = ((int) (tot / 3. * 100 + 0.5) / 100.);
			for(int x = 0; x < str.length; x++)
				pw.print(str[x] + "\t");
			pw.print(tot + "\t");
			pw.print(ave + "\n");
		}
		scn.close();
		pw.close();
	}

}
