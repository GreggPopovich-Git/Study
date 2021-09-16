/* 4대 중첩 클래스
 * 1. 내부(중첩)클래스 - Inner class
 * 2. 정적중첩 클래스
 * 3. 지역중첩 클래스
 * 4. 익명중첩 클래스
 * 
 * Source File ~.java => 컴파일 (번역) : javac.exe이용 (javac Exam_01.java) => 바이트 코드 ~.class => JVM
 */

class Outer {
	int x = 100; // 맴버필드 (변수)
	Outer() {
		System.out.println("생성자 호출");
	} // default 생성자
	void disp() { // method
		System.out.println("x = " + x);
	}
}
public class Exam_01 {

	public static void main(String[] args) {
		Outer outer = new Outer();// Heap 영역에 객체(인스턴스)가 생성되고 Stack 영역에 참조변수 가 생성됨 참조(레퍼런스) 변수에 객체(인스턴스)의 참조값(주소 - 해쉬코드)가 저장됨
		int var = 100;
		System.out.println("var변수가 가지고 있는 값 출력 : " + var);
		System.out.println("outer 변수가 참조하는 주소 출력 : " + outer);
		outer.disp();
		outer.x = 200;
		outer.disp();
	}

}