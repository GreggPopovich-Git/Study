package setexam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exam_03 {

	public static void main(String[] args) {
		Set<String> nameSet = new HashSet<String>();
		nameSet.add("박학생");
		nameSet.add("김학생");
		nameSet.add("강학생");
		nameSet.add("장학생");
		nameSet.add("유학생");
		
		System.out.println("Set Data : " + nameSet);
		// List 변환
		List<String> nameList = new ArrayList<String>(nameSet);
		System.out.println("List Data : " + nameList);
		Collections.sort(nameList);
		System.out.println("Sort Data : " + nameList);
		nameList.set(1, "이학생");
		System.out.println("List Data : " + nameList);
		
		
	}

}
