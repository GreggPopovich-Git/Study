package exam01;
abstract class BB { // 클래스 안에 하나라도 추상 메소드가 존재하면 그 클래스는 추상 클래스이어야 함.
	int x = 10;
	
	public void print() {
		System.out.println("x = " + x);
	}
	abstract public void data(); // 추상메소드 - 상속을 받는 클래스는 반드시 추상 메소드를 오버라이드 해야함.
	
	abstract public void test(int x, int y); // 추상메소드
}
class BBB extends BB {
	@Override
	public void data() {
		
		
	}
	@Override
	public void test(int x, int y) {
		
		
	}
}
public class Exam_02 {

	public static void main(String[] args) {
		
		
	}
}