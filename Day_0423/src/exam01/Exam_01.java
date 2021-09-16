package exam01;
class A {
	int x = 100;
	A (int x) {
		this.x = x;
	}
	void exam() {
		System.out.println("x = " + x);
	}
}

final class AA extends A { // 상속 하지 못하게 하려고 final을 붙임
	int x = 1000;
	int y = 2000;
	AA (int y) {
		// 명시적으로 상위 클래스 생성자 호출 (상위 클래스에 디폴트생성자가 없을 때 이미 있는 생성자를 강제 호출)
		super(1); // 가장 첫번째 한번만 사용가능
		this.y = y;
	}
	void exam() {
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}
}

public class Exam_01 {
	public static void main(String[] args) {
		
	}
}