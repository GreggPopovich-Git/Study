package exam03;

public class Exam_08 {
	public static void main(String[] args) {
		A_interface aa = new A_interface() { // 인터페이스를 이용해서 익명 구현 개체를 만들 수 있음.(1회성)

			@Override
			public void method_01() {
				System.out.println("method_01 테스트");
			}

			@Override
			public void method_02() {
				System.out.println("method_02 테스트");
			}
			
		};
		aa.method_01();
		aa.method_02();
		aa.aa(); // A_interface에 있는 override 하지 않은 메소드 호출.
		A_interface.bb(); // static 으로 정의된 메소드 호출.
	}

}