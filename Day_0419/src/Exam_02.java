class BB {
	int a;
	int b;
	static int c;
	{
		System.out.println("인스턴스 초기화 블럭");
		a = 100;
	}
	static {
		System.out.println("클래스 초기화 블럭");
		c = 100;
	}
	BB() {
		System.out.println("생성자BB()");
		b = 100;
	}
}// 클래스 - 인스턴스 - 생성자 순서로 초기화 됨.
public class Exam_02 {

	public static void main(String[] args) {
		System.out.println("Exam_02");
		BB bb = new BB();
		
	}

}
