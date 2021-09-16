package com.jslhrd.weight2;

import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int stu[][] = new int[10][3];
		int cnt = 0;
		int member = -1;
		for (int x = 0; x < stu.length; x++) {
			if (member == 0)
				break;
			System.out.print("학생 등록 : ");
			for (int y = 0; y < stu[x].length; y++) {
				member = scn.nextInt();
				if (y == 0 && member == 0)
					break;
				stu[x][y] = member;
			}
			cnt++;
		}
		Stud nn = new Stud();
		nn.sort(stu, cnt);
		nn.print(stu, cnt);
		nn.maxmin(stu, cnt);
	}

}
