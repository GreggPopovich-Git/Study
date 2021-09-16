package dept;

import java.util.Scanner;

public class SawonExam {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Sawon[] sa = new Sawon[10];
		int cnt = 0;
		//데이터 입력
		for (int x = 0; x < sa.length; x++) {
			System.out.print("사원등록 : ");
			String bu = scn.next();
			if (bu.equalsIgnoreCase("end"))
				break;
			int sabun = scn.nextInt();
			String name = scn.next();
			int pay = scn.nextInt();
			sa[x] = new Sawon(bu,sabun,name,pay);
			cnt++;
		}
		//데이터 처리
		SawonProcess saPro = new SawonProcess(sa,cnt);
		saPro.sawonPrint();
		scn.close();
	}
}