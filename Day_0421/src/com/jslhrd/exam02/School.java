package com.jslhrd.exam02;

public class School {

	public static void main(String[] args) {
		Student student1 = new Student();
		student1.setHakbun("1102");
		student1.setName("박학생");
		student1.setPhone("2222");
		student1.setGender("F");
		student1.setBirth("951115");
		//출력테스트
		System.out.println("학번\t이름\t전화\t성별\t생일");
		System.out.println(student1.getHakbun() + "\t" + student1.getName() + "\t" + student1.getPhone() + "\t" + student1.getGender() + "\t" + student1.getBirth());
		Student student2 = new Student("1101","이학생","1111","M","861005");
		System.out.println(student2.getHakbun() + "\t" + student2.getName() + "\t" + student2.getPhone() + "\t" + student2.getGender() + "\t" + student2.getBirth());
		
	}
}