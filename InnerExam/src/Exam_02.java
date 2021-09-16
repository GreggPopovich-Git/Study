// 1. 내부 중첩(Inner) 클래스
class OuterA {
	int x = 100;
	OuterA() {
		System.out.println("OuterA() 생성자 호출 ");
	}
	class InnerA { // 내부 중첩 클래스
		int y = 200;
		InnerA() {
			System.out.println("InnerA() 생성자 호출");
		}
		void disp_in() {
			disp();
			System.out.println("x = " + x);
			System.out.println("y = " + y);
		}
	}
	void disp() {
		System.out.println("x = " + x);
	}
}

public class Exam_02 {
	public static void main(String[] args) {
	OuterA a = new OuterA();
	OuterA.InnerA aa1 = a.new InnerA(); // 내부객체 생성방법 1 - a 를 이용해서 만들었기 떄문에 a 의 값을 공유
	OuterA.InnerA aa2 = a.new InnerA(); // 내부객체 생성방법 1 - a 를 이용해서 만들었기 떄문에 a 의 값을 공유
	
	OuterA.InnerA aaa = new OuterA().new InnerA(); // 내부객체 생성방법 2 - a를 이용하지 않고 독립적인 객체를 생성함.
	a.disp();
	System.out.println("--------------------------");
	a.x = 1000;
	aa1.disp_in();
	System.out.println("--------------------------");
	
	aa2.disp_in();
	System.out.println("--------------------------");
	aaa.disp_in();
	
	}
}
