package lambda;
// 함수적 인터페이스(@FunctionalInterface) - method가 하나밖에 없는 인터페이스
@FunctionalInterface
interface MyFunction {
	public void method();
}
// 매개변수 x, 리턴타입 x
public class LambdaEx_03 {
	public static void main(String[] args) {
		MyFunction fi = () -> {
			String str = "Method Call";
			System.out.println(str);
		};
		fi.method();
		
		fi = () -> System.out.println("Method Call 2");
		fi.method();
	}

}
