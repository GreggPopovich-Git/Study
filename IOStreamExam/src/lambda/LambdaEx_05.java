package lambda;
// 함수적 인터페이스(@FunctionalInterface) - method가 하나밖에 없는 인터페이스
@FunctionalInterface
interface MyFunction3 {
	public int method(int x, int y);
}
// 매개변수 o, 리턴타입 o
public class LambdaEx_05 {
	public static void main(String[] args) {
		MyFunction3 fi = null;
		fi = (x, y) -> {
			int result = x * y;
			return result;
		};
		System.out.println(fi.method(5, 5));
		
		fi = (x, y) -> {return (x * y);};
		System.out.println(fi.method(7, 7));
		
		fi = (x, y) -> x * y; // return 생략 가능
		System.out.println(fi.method(9, 9));
		
		
	}

}
