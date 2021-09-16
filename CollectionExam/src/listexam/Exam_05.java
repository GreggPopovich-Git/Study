package listexam;

import java.util.ArrayList;
import java.util.List;

class Student {
	private int id;
	private String name;
	private int age;
	
	Student(){}
	Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		
		return id + "\t" + name + "\t" + age;
	}
	
}
public class Exam_05 {

	public static void main(String[] args) {
		List<Student> sList = new ArrayList<Student>();
		sList.add(new Student(5, "김학생", 27));
		sList.add(new Student(3, "김장생", 30));
		sList.add(new Student(1, "최학생", 25));
		sList.add(new Student(2, "강학생", 27));
		sList.add(new Student(4, "박학생", 28));
		
		System.out.println("학생입력자료 리스트");
		System.out.println("번호\t이름\t나이");
		for (Student student : sList) {
			System.out.println(student);
		}
		// 학생 자료를 번호순으로 정렬
		studentSort(sList);
		System.out.println("학생 번호순 리스트");
		System.out.println("번호\t이름\t나이");
		for (Student student : sList) {
			System.out.println(student);
		}
	}
	// 번호 Student 객체를 매개값으로 받아서 번호를 기준으로 오름차순 정렬
	static void studentSort(List<Student> list) {
		for (int x = 0; x < list.size()-1; x++) {
			for(int y = x + 1; y < list.size(); y++) {
				Student stu1 = list.get(x);
				Student stu2 = list.get(y);
				if (stu1.getId() > stu2.getId()) {
					list.set(y, stu1);
					list.set(x, stu2);
				}
			}
		}
	}
}
