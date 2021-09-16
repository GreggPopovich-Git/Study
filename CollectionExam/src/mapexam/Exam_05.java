package mapexam;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Exam_05 {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("김학생", 95);
		map.put("박학생", 100);
		map.put("강학생", 88);
		map.put("장학생", 75);
		map.put("오학생", 90);
		map.put("유학생", 69);
		
		Set set = map.entrySet();
		Iterator iter = set.iterator();
		System.out.println("이름\t점수");
		while(iter.hasNext()) {
			Map.Entry entry = (Map.Entry)iter.next();
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
		// 참가자 명단 출력
		Set mCnt = map.keySet();
		System.out.println("참가자 명단 : " + mCnt);
		// 점수만을 이용하여 총점, 평균, 최고점, 최저점
		Collection values = map.values();
		Iterator vIter = values.iterator();
		int tot = 0;
		while(vIter.hasNext()) {
			int score = (Integer)vIter.next();
			tot += score;
		}
		System.out.println("총점 : " + tot);
		System.out.println("평균 : " + tot/map.size());
		System.out.println("최고점 : " + Collections.max(values));
		System.out.println("최저점 : " + Collections.min(values));
	}

}