// 증감 연산자(후위형)
public class Exam_03 {
	public static void main(String[] args) {
		int a = 5, b = 0;
		a++; // a==6, b==0
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("------------------------");
		b = a++; // a==7, b==6 (a값을 b에 대입 후 ++연산)
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("------------------------");
	}

}
