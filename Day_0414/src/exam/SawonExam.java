package exam;

import java.util.Scanner;

public class SawonExam {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Sawon sa[] = new Sawon[10];
		int tot[] = new int[10];
		int payTot = 0;
		int cnt = 0;
		while (true) {
			System.out.print("출장비 등록 : ");
			String name = scn.next();
			if (name.equalsIgnoreCase("end"))
				break;
			int money = scn.nextInt();
			payTot += money;
			sa[cnt] = new Sawon(name, money);
			cnt++;
		}
		System.out.println("성명\t출장비\t50,000원\t10,000원\t5,000원\t1,000원\t500원\t100원\t50원\t10원\t5원\t1원");
		for (int i = 0; i < cnt; i++)
			sa[i].print();
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < tot.length; j++) {
				tot[j] += sa[i].money[j];
			}
		}
		System.out.print("합계 : \t" + payTot + "\t");
		for (int i = 0; i < tot.length; i++)
			System.out.print(tot[i] + "\t");
		scn.close();
	}

}
