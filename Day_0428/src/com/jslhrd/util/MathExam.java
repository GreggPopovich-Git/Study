package com.jslhrd.util;

public abstract class MathExam {
	public String hakbun;
	public String name;
	public int score[];
	public int tot;
	public double ave;
	public String memo;
	public MathExam(String hakbun, String name, int[] score) {
		this.hakbun = hakbun;
		this.name = name;
		this.score = score;
	}
	public void titlePrint() {
		System.out.println("학년\t반\t번호\t이름\t총점\t평균\t비고");
	}
	public abstract void totAve();
	public abstract void memoAccount(double var);
	public abstract void dataPrint();
}
