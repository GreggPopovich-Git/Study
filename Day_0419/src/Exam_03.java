class CC {
	int a;
	boolean b;
	String c;
	
	
	CC(){} // 디폴트 생성자
	CC(int a) {
		this(a,true); // 세번째 생성자 CC를 호출함. 가장 첫줄에 한번만 쓸 수 있음.
		this.a = a;
	}
	CC(int a, boolean b) {
		this(a, b, "홍길동"); // 네번째 생성자 CC를 호출함.
		this.b = b;
	}
	CC(int a, boolean b, String c) {
		this.c = c;
	}
	
	public void print() {
		System.out.println(a + "\t" + b + "\t" + c);
	}
}
public class Exam_03 {

	public static void main(String[] args) {
		CC c1 = new CC();
		c1.print();
		c1.a = 10;
		c1.b = true;
		c1.c = "AAA";
		c1.print();
		
		CC c2 = new CC(1000);
		c2.print();
	}

}