package setexam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// set : 저장 순서가 지정되지 않고 중복 데이터가 들어가지 않음.
public class Exam_01 {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("Seoul");
		set.add(12345);
		set.add("JSL");
		set.add("Java");
		set.add(12345);
		set.add("HRDKorea");
		System.out.println("set : " + set);
		System.out.print("확장 for : ");
		for (Object obj : set)
			System.out.print(obj + "\t");
		System.out.println();
		System.out.print("Iterator : ");
		Iterator iter = set.iterator(); // 반복자 사용법
		while (iter.hasNext())
			System.out.print(iter.next() + "\t");
		
		// Set List로 변환
		System.out.println();
		List list = new ArrayList(set);
		System.out.println("List : " + list);
		
	}

}