class BB {
	private static BB bb = new BB(); // 클래스가 스스로 객체를 생성
	private BB() {} // 싱글톤 - 디폴트 생성자를 사용하지 못하게 하므로써 객체를 생성하지 못하게 함.
	public static BB getInstance() { // 생성된 객체를 메소드로 만들어서 사용할 수 있게 만듬.
		return bb;
	}
}
public class Exam_02 {
	public static void main(String[] args) {
		//BB b1 = new BB(); 인스턴스 생성 안됨
		BB b1 = BB.getInstance(); // 객체를 생성하지 못하는 반면 static으로 생성된 메소드를 이용. (공유)
		BB b2 = BB.getInstance();
		System.out.println(b1 == b2);
		BB b3 = BB.getInstance();
		BB b4 = BB.getInstance();
		System.out.println(b1 == b3);
		System.out.println(b2 == b4);
		
	}

}