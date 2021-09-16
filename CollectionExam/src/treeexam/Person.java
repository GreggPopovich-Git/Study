package treeexam;

public class Person implements Comparable<Person> {
	String name;
	int age;
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public int compareTo(Person o) {
		//return Integer.compare(age, o.age); // 나이 오름차순
		if(age < o.age)
			return -1;
		else if(age == o.age)
			return 0;
		else
			return 1;
	}
}