// 오버라이딩 : 조상 클래스의 메소드와 이름은 같지만 내용을 다르게 하는 것 (다형성)
package exam01;
class B { // final을 클래스 앞에 붙이면 상속이 안됨. 메소드 앞에 붙이면 overrides가 안됨.
	int x = 10;
	public void test() {
		System.out.println("B 클래스 x = " + x);
	}
	public int sum(int a, int b) {
		return a+b;
	}
}
class BA extends B {
	int x = 100; // 조상클래스의 x 가 은닉 됨.
	public void test() {
		super.test(); // 오버라이딩 했을 때 은닉 된 조상클래스의 메소드를 호출 하는 키워드 super
		System.out.println("BA 클래스 x = " + this.x);
	}
}
class BB extends B {
	int x = 1000; // 조상클래스의 x 가 은닉 됨.
	public void test() { // 오버라이딩 : 메소드 이름, 매개변수까지 완벽히 같아야 함. 하나라도 다르면 독자적인 메소드.
		System.out.println("BB 클래스 x = " + x);
	}
	public int sum(int a, int b) { // 오버라이딩
		return a*b;
	}
}
class BC extends B {
	
}
public class Exam_02 {
	public static void main(String[] args) {
		BA ba = new BA();
		ba.test();
		System.out.println("sum = " + ba.sum(10, 20));
		System.out.println("--------------------------------------------");
		BB bb = new BB();
		bb.test();
		System.out.println("sum = " + bb.sum(10, 20));
	}
}