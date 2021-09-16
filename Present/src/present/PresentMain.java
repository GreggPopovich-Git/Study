package present;

import java.util.Scanner;

public class PresentMain {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int price[] = new int[10];
		String name[] = new String[10];
		int cnt = 0;
		for (int i = 0; i < price.length; i++) {
			System.out.print((i+1) + "번째 선물이름과 가격을 입력하세요(구분자는 공백) : ");
			String imsi[] = scn.nextLine().split(" ");
			if (imsi[0].equalsIgnoreCase("end"))
				break;
			name[i] = imsi[0];
			price[i] = Integer.parseInt(imsi[1]);
			cnt++;
		}
		PresentSubClass sub = new PresentSubClass(price,name,cnt);
		sub.print();
		scn.close();
	}
}