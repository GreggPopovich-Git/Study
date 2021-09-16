package com.jslhrd.util;

public class Student extends MathExam {

	public Student(String hakbun, String name, int[] score) {
		super(hakbun, name, score);
		totAve();
		memoAccount(ave);
	}
	@Override
	public void totAve() {
		for (int x = 0; x < score.length; x++) {
			tot += score[x];
		}
		ave = (int)(tot / (double)score.length * 10 + 0.5) / 10.;
	}
	@Override
	public void memoAccount(double var) {
		if (var >= 90)
			memo = "수";
		else if (var >= 80)
			memo = "우";
		else if (var >= 70)
			memo = "미";
		else if (var >= 60)
			memo = "양";
		else
			memo = "가";
	}
	public void titlePrint() {
		System.out.println("학년\t반\t번호\t이름\t총점\t평균\t비고");
		dataPrint();
	}
	@Override
	public void dataPrint() {
		System.out.print(hakbun.substring(0, 1) + "\t");
		System.out.print(hakbun.substring(1, 2) + "\t");
		System.out.print(hakbun.substring(2) + "\t");
		System.out.print(name + "\t");
		System.out.print(tot + "\t" + ave + "\t" + memo);
	}

}
