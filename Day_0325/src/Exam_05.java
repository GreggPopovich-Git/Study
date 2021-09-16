// 증감 연산자
public class Exam_05 {
	public static void main(String[] args) {
		int a=1, b=0;
		b= a++ + a++ + a++;
		System.out.println(a + ", " + b);
		int aa=1, bb=0;
		bb= ++aa + ++aa + ++aa;
		System.out.println(aa + ", " + bb);

	}

}
