package mapexam;

import java.util.HashMap;
import java.util.Map;

public class Exam_06 {

	public static void main(String[] args) {
		Map<Student, Integer> sMap = new HashMap<Student, Integer>();
		sMap.put(new Student(1, "김학생"), 95);
		sMap.put(new Student(5, "김학생"), 90);
		sMap.put(new Student(1, "김학생"), 88);
		sMap.put(new Student(3, "장학생"), 75);
		
		System.out.println("총학생수 : " + sMap.size());
	}

}