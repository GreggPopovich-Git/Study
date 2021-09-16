package mapexam;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Exam_07 {

	public static void main(String[] args) {
		Map<Student, Integer> sMap = new HashMap<Student, Integer>();
		sMap.put(new Student(1, "김학생"), 95);
		sMap.put(new Student(5, "김학생"), 90);
		sMap.put(new Student(4, "장학생"), 88);
		sMap.put(new Student(3, "윤학생"), 75);
		sMap.put(new Student(7, "박학생"), 100);
		// 1. 키보드로 학생정보를 입력 받아서 sMap 객체에서 검색하여 존재하는 학생정보와 점수를 출력하고 없으면 "xxx 학생정보가 없음" 출력
		Scanner scn = new Scanner(System.in);
		for(;;) {
			System.out.print("학생정보 입력 : ");
			String[] str = scn.nextLine().split(",");
			if(str[0].equalsIgnoreCase("end"))
				break;
			Student stu = new Student(Integer.parseInt(str[0]), str[1]);
			if(sMap.containsKey(stu))
				System.out.println(stu + "\t" + sMap.get(stu));
			else
				System.out.println(stu.getName() + " 학생정보가 없음");
		}
		// 2. 학생정보만 출력(번호 이름)
		System.out.println("번호\t이름");
		Set<Map.Entry<Student, Integer>> set = sMap.entrySet();
		Iterator<Map.Entry<Student, Integer>> iter = set.iterator();
		while(iter.hasNext()) {
			Map.Entry<Student, Integer> entry = iter.next();
			System.out.println(entry.getKey().getSno() + "\t" + entry.getKey().getName());
		}
		// 3. 학생전체의 총점 평균 출력
		Collection value = sMap.values();
		Iterator iter2 = value.iterator();
		int tot = 0;
		while(iter2.hasNext()) {
			int score = (int) iter2.next();
			tot += score;
		}
		System.out.println("총점 : " + tot);
		System.out.println("평균 : " + tot/sMap.size());
		// 4. 최고점, 최저점. 최고점과 최저점의 차이 출력
		System.out.println("최고점 : " + Collections.max(value));
		System.out.println("최저점 : " + Collections.min(value));
		System.out.println("최고점과 최저점의 차이 : " + ((Integer)Collections.max(value) - (Integer)Collections.min(value)));
		scn.close();
	}
}