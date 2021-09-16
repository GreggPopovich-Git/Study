// 2. 정적(static)중첩 클래스
class OuterB {
	int x = 100;
	static int y = 200;
	void disp() {
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}
	static class InnerB { // Outer의 정적만 포함
		int z = 300;
		static int max = 100;
		void disp_in() {
			//System.out.println("x = " + x); 정적 변수가 아니라서 접근 하지 못함.
			System.out.println("y = " + y);
			System.out.println("z = " + z);
		}
	}
}
public class Exam_03 {
	public static void main(String[] args) {
		OuterB b = new OuterB();
		b.disp();
		OuterB.InnerB bb = new OuterB.InnerB();
		bb.disp_in();
		System.out.println("max = " + OuterB.InnerB.max);
		
	}

}
