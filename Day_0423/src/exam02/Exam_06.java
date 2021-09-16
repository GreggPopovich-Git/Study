package exam02;
class A {
	int x = 100;
}
class B extends A {
	int y = 200;
}
public class Exam_06 {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B(); // 업캐스팅
		a2.x = 1000;
		B b1 = new B();
		B b2 = (B) a2; // 다운캐스팅
		b2.x = 1000;
		b2.y = 2000;
		B b3 = (B) a1; // 컴파일 (O), 런타임 (X)
		b2.x = 1000;
		b2.y = 2000;
		B bb = (B) new A(); // 컴파일 (O), 런타임 (X)
		
	}
}