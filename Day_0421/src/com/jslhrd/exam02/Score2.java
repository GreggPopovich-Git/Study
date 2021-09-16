package com.jslhrd.exam02;

public class Score2 {
	private Student student; // 학생 클래스
	private int kor; // 국어점수
	private int eng; // 영어점수
	private int mat; // 수학점수
	private int tot; // 총점
	private double ave; // 평균
	private String memo; // 학점

	
	public Score2() {}
	public Score2(Student student, int kor, int eng, int mat) {
		this.student = student;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		ave = (int)(tot / 3. * 100 + 0.5) / 100.;
		if (ave >= 90)
			memo = "A";
		else if (ave >= 80)
			memo = "B";
		else if (ave >= 70)
			memo = "C";
		else if (ave >= 60)
			memo = "D";
		else
			memo = "F";
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAve() {
		return ave;
	}
	public void setAve(double ave) {
		this.ave = ave;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
}
