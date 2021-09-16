package listexam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 지네릭(generic) 타입
public class Exam_03 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(); // 문자열 전용 List
		boolean bool = list.add("김학생"); // 데이터 추가가 성공했는지 실패했는지 판별 가능.
		System.out.println(bool);
		list.add("Java");
		list.add("박학생");
		list.add("장학생");
		list.add("유학생");
		// list.add(123); 오류
		
		System.out.println(list);
		list.set(1, "강학생");
		System.out.println(list);
		System.out.println(list.indexOf("장학생")); // 몇번째 위치해 있는지 찾기
		System.out.println(list.contains("장학생")); // list 안에 데이터가 존재 하는지 여부 boolean 값
		Collections.sort(list);
		System.out.println(list);
	}
}