package treeexam;

import java.util.Iterator;
import java.util.TreeSet;

public class Exam_03 {

	public static void main(String[] args) {
		TreeSet<Person> pTree = new TreeSet<Person>();
		pTree.add(new Person("김학생", 28));
		pTree.add(new Person("박학생", 20));
		pTree.add(new Person("강학생", 25));
		pTree.add(new Person("장학생", 30));
		pTree.add(new Person("유학생", 27));
		
		System.out.println(pTree);
		Iterator<Person> iter = pTree.iterator();
		while(iter.hasNext()) {
			Person p = iter.next();
			System.out.println(p.name + "\t" + p.age);
		}
	}
}