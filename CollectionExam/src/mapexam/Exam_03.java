package mapexam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Exam_03 {

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("B", 100);
		map.put("A", 90);
		map.put("D", 88);
		map.put("C", 70);
		map.put("E", 44);
		map.put("A", 22); // key 중복
		map.put("F", 33);
		
		Set<Map.Entry> set = map.entrySet(); // entry(key+value) 형태로 Set에 저장
		Iterator<Map.Entry> iter = set.iterator();
		while(iter.hasNext()) {
			Map.Entry entry = iter.next();
			System.out.println("Key : " + entry.getKey());
			System.out.println("Value : " + entry.getValue());
		}
		
	}

}