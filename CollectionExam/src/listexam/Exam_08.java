package listexam;

import java.util.Vector;

// Vector == ArrayList / 차이점은 Vector는 동기화 지원 (동시에 여러 스레드를 이용할 때 사용)
public class Exam_08 {

	public static void main(String[] args) {
		Vector vec = new Vector();
		vec.add("김학생");vec.add(123);
		vec.add("박학생");vec.add(456);
		vec.add("장학생");vec.add(789);
		vec.add("강학생");vec.add(012);
		vec.add("오학생");vec.add(011);
		vec.add("윤학생");vec.add(013);
		System.out.println("벡터 내용 : " + vec);
		System.out.println("벡터 객체 수 : " + vec.size());		// 백터에 저장된 객체수
		System.out.println("벡터 용량 : " + vec.capacity());	// 백터용량
		
	}

}