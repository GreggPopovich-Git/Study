package lambda;
// 함수적 인터페이스(@FunctionalInterface) - method가 하나밖에 없는 인터페이스
@FunctionalInterface
interface MyFunction2 {
	public void method(int x);
}
// 매개변수 o, 리턴타입 x
public class LambdaEx_04 {
	public static void main(String[] args) {
		MyFunction2 fi = null;
		fi = (x) -> {
			int result = x * 5;
			System.out.println("result = " + result);
		};
		fi.method(5);
		
		fi = (x) -> System.out.println(x * 5);
		fi.method(10);
		
	}

}
