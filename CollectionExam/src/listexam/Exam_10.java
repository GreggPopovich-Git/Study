package listexam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LinkedList - 삽입, 삭제가 빈번할 경우 유리함.
public class Exam_10 {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		long startTime;
		long endTime;
		// ArrayList 소요시간
		//startTime = System.currentTimeMillis();
		startTime = System.nanoTime();
		for(int x = 0; x < 10000; x++) {
			list1.add(0,String.valueOf(x));
		}
		//endTime = System.currentTimeMillis();
		endTime = System.nanoTime();
		System.out.println("ArrayList 소요시간 : " + (endTime - startTime));
		// LinkedList 소요시간
		//startTime = System.currentTimeMillis();
		startTime = System.nanoTime();
		for(int x = 0; x < 10000; x++) {
			list2.add(0,String.valueOf(x));
		}
		//endTime = System.currentTimeMillis();
		endTime = System.nanoTime();
		System.out.println("LinkedList 소요시간 : " + (endTime - startTime));
	}

}