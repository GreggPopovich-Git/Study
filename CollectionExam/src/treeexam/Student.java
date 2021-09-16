package treeexam;

public class Student implements Comparable<Student> {
	int num;
	String name;
	
	Student(){}
	Student(int num, String name) {
		this.num = num;
		this.name = name;
	}
	@Override
	public int compareTo(Student o) {
		if(num < o.num)
			return -1;
		else if(num == o.num)
			return 0;
		else
			return 1;
	}
	@Override
	public String toString() {
		return num + "\t" + name;
	}
}
