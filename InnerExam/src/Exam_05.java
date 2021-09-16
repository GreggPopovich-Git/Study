// 4. 익명중첩
class InnerD {
	int a = 100;
	void aaa() {
		System.out.println("AAAAA");
	}
	void bbb() {
		System.out.println("BBBBB");
	}
	
}
public class Exam_05 {

	public static void main(String[] args) {
		InnerD in = new InnerD();
		in.aaa();
		in.bbb();
		InnerD inD = new InnerD() { // 인터페이스의 익명구현 할때처럼 익명 객체 생성 해서 override 할 수 있음.
			@Override
			void aaa() {
				System.out.println("AAAAA\tBBBBB");
				System.out.println(a); // 기존 클래스에 있는 변수도 그대로 사용 가능.
			}
			@Override
			void bbb() {
				super.bbb();
				System.out.println("bbb() -> AAAAA");
			}
			/*
			void exam() { // 추가 불가 - 런타임 오류
				
			}
			*/
		};
		inD.aaa();
		inD.bbb();
	}

}