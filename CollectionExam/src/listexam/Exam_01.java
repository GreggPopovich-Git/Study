package listexam;

import java.util.ArrayList;
import java.util.List;
class Car {
	
}
public class Exam_01 {

	public static void main(String[] args) {
		// List list = new List(); List는 인터페이스이기 때문에 객체 생성이 안됨.
		List list = new ArrayList();
		System.out.println("목록이 비어있는지 : " + list.isEmpty());
		list.add(1234); // 자동으로 object로 변환 해서 추가됨.
		list.add("김학생");
		list.add(3.14);
		list.add(new Car()); // 참조값을 object로 변환 해서 추가됨.
		list.add(1,"AAA");
		System.out.println("저장된 목록 수 : " + list.size());
		System.out.println("0번째 목록 : " + list.get(0));
		
	}

}
