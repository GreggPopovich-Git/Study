package com.jslhrd.sungjuk2;

import java.util.Scanner;

public class StudentExam {

	public static void main(String[] args) {
		//Data Input
		Scanner scn = new Scanner(System.in);
		Student hak[] = new Student[10];
		int cnt = 0;
		for (int x = 0; x < hak.length; x++) {
			System.out.print("학생등록 : ");
			String name = scn.next();
			if (name.equalsIgnoreCase("0"))
				break;
			hak[x] = new Student(name,scn.next(),scn.nextInt(),scn.nextInt(),scn.nextInt());
			cnt++;
		}
		hak[0].menu();
		for (int x = 0; x < cnt; x++) {
			hak[x].print();
		}
		scn.close();
	}

}