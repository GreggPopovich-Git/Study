package lambda;

// 람다(lambda)식 자바 1.8버전 이후에 등장
// 메소드를 하나의 식처럼 사용하는 것 - 인터페이스에 메소드가 하나밖에 없을 때
@FunctionalInterface // 함수적인터페이스(메소드가 하나밖에 없는 인터페이스)
interface Test {
	public void method();
}

class ClassA implements Test { // 클래스를 이용한 구현, 오버라이드
	@Override
	public void method() {
		System.out.println("AAA");
	}
}

public class LambdaEx_01 {
	public static void main(String[] args) {
		// 익명 구현 개체
		Test a = new Test() {
			@Override
			public void method() {
				System.out.println("AAAA");
			}
		};
		a.method();

		// lambda
		Test tt = () -> System.out.println("BBBB");
		tt.method();
	}

}
