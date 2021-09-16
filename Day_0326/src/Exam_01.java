// 비트 연산자: 비트논리연산자(~, &, |, ^), 이동연산자 shift(<<-x*2^n, >>-x/2^n, >>>-x/2^n)
// ~(not-보수연산자), |(or-데이터 삽입 및 수정), &(and-데이터 삭제), ^(xor-배타적인 or), 
public class Exam_01 {
	public static void main(String[] args) {
		int a = 5;
		System.out.println(a);
		System.out.println(~a);
		
		System.out.println(7|5);
		System.out.println(7&5);
		System.out.println(3|5);
		System.out.println(3&5);
		System.out.println(7^5);
		
	}

}
