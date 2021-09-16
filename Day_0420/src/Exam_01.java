// 싱글톤 : 하나의 인스턴스만 생성하고 하나의 인스턴스를 공유
class AA {
	int x = 100; // 명시적인 초기화
	{
		x = 100; // 초기화 블럭을 이용한 초기화
	}
	
}
public class Exam_01 {
	public static void main(String[] args) {
		AA a1 = new AA();  // 인스턴스(객체) 생성
		AA a2 = new AA();  // a1 != a2
		System.out.println(a1 == a2);
		AA a3 = a1;		   // a1 == a3
		System.out.println(a1 == a3);
		
	}
}