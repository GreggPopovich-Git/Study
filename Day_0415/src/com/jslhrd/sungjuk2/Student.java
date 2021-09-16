package com.jslhrd.sungjuk2;

public class Student {
	String number,name,reason,bool;
	int kor,eng,mat,tot;
	double ave;
	
	Student() {}
	Student(String number, String name, int kor, int eng, int mat) {
		this.number = number;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		ave = (int)(tot / 3. * 100 + 0.5)/100.;
		reason = "";
		if (kor < 40 || eng < 40 || mat < 40) {
			this.bool = "불합격";
			this.reason = "과락 ";
		}
		else if (ave < 60) {
			this.bool = "불합격";
			this.reason = "평균미달";
		}
		else {
			this.bool = "합격";
			this.reason = "";
		}
	}
	public void menu() {
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균\t판정\t사유");
	}
	public void print() {
		System.out.print(number + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t");
		System.out.println(tot + "\t" + ave + "\t" + bool + "\t" + reason);
	}
}