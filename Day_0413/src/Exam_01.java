/* Method의 정의 및 호출법
 * 1. method는 class에 소속 되어야 함.
 * 2. class는 항상 main method 부터 실행됨.
 * 
 */
public class Exam_01 { //main method가 들어가면 이 클래스는 실행 클래스
	//method 정의
	static void print() {
		System.out.println("Hello World!");
	}
	static void print2(String str) {
		System.out.println("Hello : " + str);
	}
	public static void main(String[] args) {
		print();
		print2("안녕하세요");
		
		
	}
	//method 정의

}
