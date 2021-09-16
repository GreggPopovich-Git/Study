package setexam;
// Object List Sort
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class AA implements Comparable<AA> {
	int bun;
	String name;
	AA(int bun, String name) {
		this.bun = bun;
		this.name = name;
	}
	@Override
	public String toString() {
		return bun + ", " + name;
	}
	// 문자열 기준
	@Override
	public int compareTo(AA o) {
		return name.compareTo(o.name);
	}
	/*
	// 숫자 기준
	@Override
	public int compareTo(AA o) {
		if(bun < o.bun)
			return -1;
		else if(bun == o.bun)
			return 0;
		else
			return 1;
	}
	*/
}
public class Exam_07_objectListSort {
	public static void main(String[] args) {
		List<AA> list = new ArrayList<AA>();
		list.add(new AA(1,"DDD"));
		list.add(new AA(5,"AAA"));
		list.add(new AA(3,"FFF"));
		list.add(new AA(7,"SSS"));
		list.add(new AA(2,"BBB"));
		System.out.println("Sort 전");
		System.out.println(list);
		System.out.println("Sort 후");
		Collections.sort(list);
		System.out.println(list);
		
	}

}