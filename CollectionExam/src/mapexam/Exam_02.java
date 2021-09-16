package mapexam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Exam_02 {

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("B", 100);
		map.put("A", 90);
		map.put("D", 88);
		map.put("C", 70);
		map.put("E", 44);
		map.put("A", 22); // key 중복
		map.put("F", 33);
		
		Set Set = map.keySet();
		Iterator iter = Set.iterator();
		
		while(iter.hasNext()) {
			Object key = iter.next();
			Object value = map.get(key);
			System.out.println(key + " : " + value);
		}
		
	}

}