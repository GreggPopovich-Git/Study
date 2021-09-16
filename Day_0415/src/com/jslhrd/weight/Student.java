package com.jslhrd.weight;
import java.util.Scanner;
public class Student {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		StudentCal stu[] = new StudentCal[10];
		int cnt = 0;
		//입력
		for (int x = 0; x < stu.length; x++) {
			System.out.print("학생 등록 : ");
			int clas = scn.nextInt();
			if (clas == 0)
				break;
			int num = scn.nextInt();
			int wei = scn.nextInt();
			stu[x] = new StudentCal(clas,num,wei);
			cnt++;
		}
		//호출
		stu[0].sort(stu, cnt);
		stu[0].print(stu, cnt);
		stu[0].maxmin(stu, cnt);
		scn.close();
	}
}