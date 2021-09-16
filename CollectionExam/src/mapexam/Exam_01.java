package mapexam;

import java.util.HashMap;
import java.util.Map;

public class Exam_01 {

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("A", 100);
		map.put("B", 90);
		map.put("C", 88);
		map.put("A", 70); // key 중복
		System.out.println(map);
		
		System.out.println("A : " + map.get("A"));
		System.out.println("Size : " + map.size());
		System.out.println("isEmpty : " + map.isEmpty());
		System.out.println("Key A : " + map.containsKey("A"));
		System.out.println("Value 90 : " + map.containsValue(90));
		
	}

}