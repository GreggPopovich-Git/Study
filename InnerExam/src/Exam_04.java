// 3. 지역(Local)중첩 클래스 - method 안에 클래스가 들어감. method가 호출 될 때 클래스가 생성됨.
class OuterC {
	int x = 100;
	int y = 200;
	void disp() {
		class InnerC {
			int a = 10;
			int b = 20;
			void disp_in() {
				System.out.println("x = " + x);
				System.out.println("y = " + y);
				System.out.println("a = " + a);
				System.out.println("b = " + b);
			}
		}
		InnerC in = new InnerC();
		in.disp_in();
	}
	
}
public class Exam_04 {

	public static void main(String[] args) {
		OuterC ot = new OuterC();
		//OuterC.InnerC oi = ot.new InnerC(); method안에 클래스가 정의 되어 있어서 OuterC를 이용해서 객체 생성이 불가능.
		ot.disp();
		
	}

}
