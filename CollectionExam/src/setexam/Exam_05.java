package setexam;

import java.util.HashSet;
import java.util.Set;

// 이름과 나이가 같으면 같은 객체로 인식하는가
public class Exam_05 {

	public static void main(String[] args) {
		Set<Member> mSet = new HashSet<Member>();
		mSet.add(new Member("김학생", 30));
		mSet.add(new Member("이학생", 30));
		mSet.add(new Member("김학생", 20));
		mSet.add(new Member("김학생", 30)); // 중복
		mSet.add(new Member("박학생", 29));
		
		System.out.println("Member : " + mSet);
		
		
	}

}