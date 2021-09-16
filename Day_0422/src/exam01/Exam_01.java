// 상속 - 조상(super or parent)클래스와 자식(child)클래스간의 상속 (키워드 : extend)
// JAVA 는 다중상속이 안됨. private 으로 정의된 것은 상속이 안됨.
package exam01;
class A { // 조상 (super, parent) class
	int a = 10;
	void aPrint() {
		System.out.println("a.a = " + a);
	}
}
class AA extends A { // A클래스를 상속 받아서 AA클래스 생성
	int b = 10;
	void aaPrint() {
		aPrint(); // 조상클래스에 있는 매소드 호출
		System.out.println("a.a = " + a); //조상클래스 맴버변수
		System.out.println("aa.b = " + b);
		System.out.println("a + b = " + (a+b));
	}
}
public class Exam_01 {
	public static void main(String[] args) {
		A a1 = new A();
		a1.aPrint();
		
		AA aa1 = new AA();
		aa1.aPrint();
		aa1.aaPrint();
		
	}
}