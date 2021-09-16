// 증감 연산자(전위형)
public class Exam_04 {
	public static void main(String[] args) {
		int a = 5, b = 0;
		++a; // a==6, b==0
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("------------------------");
		b = ++a; // a==7, b==7 (a에 ++연산 후 a를 b에 대입)
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("------------------------");

	}

}
