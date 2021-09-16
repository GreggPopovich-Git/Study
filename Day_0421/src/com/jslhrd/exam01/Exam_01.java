// class diagram (UML을 사용해서 그림)
// + public, - private, # protected
// 맨 위에서 부터 클래스 이름, 필드변수, 메소드 순서로 작성.
// <<클래스 이름>> -> 인터페이스

package com.jslhrd.exam01;
class Student {
	private String hakbun;
	private String name;
	
	Student(){}
	Student(String h, String n) {
		hakbun = h;
		name = n;
	}
	public void sPrint() {
		System.out.println(hakbun + "\t" + name);
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
}

public class Exam_01 {

	public static void main(String[] args) {
		Student stu1 = new Student();
		stu1.sPrint();
		//stu1.hakbun = "1102"; //private 변수에 직접 접근 불가능. setter 와 getter method를 만들어서 우회 접근 하여 수정
		//stu1.name = "김학생";
		stu1.setHakbun("1102"); //setter method를 이용해서 값을 변경
		stu1.setName("이학생");
		stu1.sPrint(); // getter method를 이용해서 값을 꺼내옴.
		System.out.println("이름 : " + stu1.getName());
		Student stu2 = new Student("1101", "김학생");
		stu2.sPrint();
	}
}