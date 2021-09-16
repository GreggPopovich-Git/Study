package com.jslhrd.exam02;

public class Student {
	private String hakbun; // 학번
	private String name; // 이름
	private String phone; // 전화번호
	private String gender; // 성별
	private String birth; // 생년월일
	
	public Student(){}
	public Student(String h, String n, String p, String g, String b) {
		hakbun = h;
		name = n;
		phone = p;
		gender = g;
		birth = b;
	}

	public String getHakbun() {
		return hakbun;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
}
