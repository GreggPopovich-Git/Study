package listexam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
// list에 저장된 객체 출력
public class Exam_02 {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(10);
		list.add(20);
		list.add("30");
		list.add(40);
		list.add("50");
		System.out.print("list : ");
		System.out.println(list); // list의 자료를 꺼내오는 것이 아니고 list 안에 자료가 어떤게 있는지 보여주는 것.
		
		System.out.print("for : ");
		for (int x = 0; x < list.size(); x++) {
			Object obj = list.get(x);
			System.out.print(obj + "\t");
		}
		System.out.println();
		System.out.print("확장 for : ");
		for (Object obj : list)
			System.out.print(obj + "\t");
		System.out.println();
		System.out.print("Iterator(반복자) : ");
		Iterator iter = list.iterator();
		while(iter.hasNext())
			System.out.print(iter.next() + "\t");
		
	}

}