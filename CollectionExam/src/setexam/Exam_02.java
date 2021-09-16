package setexam;

import java.util.HashSet;
import java.util.Set;

public class Exam_02 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		boolean bool = set.add("Java"); // 같은 데이터를 넣었을 때 들어갔는지 판별
		System.out.println(bool);
		System.out.println(set);
		if (set.contains("Java"))
			System.out.println("포함되어있음");
		System.out.println("Set에 포함된 객체 수 : " + set.size());
		set.remove("Java"); // 객체 제거
		System.out.println("Set에 포함된 객체 수 : " + set.size());
		set.removeAll(set); // 전부 제거
		if(set.isEmpty()) // 비어있으면 true, 그렇지 않으면 false
			System.out.println("Set이 비어 있음");
		
	}

}