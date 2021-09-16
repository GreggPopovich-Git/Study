/* 변수 : 멤버(인스턴스)변수(필드), 클래스(정적)변수, 지역변수
 * JVM(Java Virtual Machine) : Method 영역(class loading), 힙영역(객채가 생성되는 영역), 스택영역(변수가 생성되는 영역)
 * 스택 : 입구와 출구가 같이 있음. 가장 먼저 만든 변수는 가장 나중에 삭제 가능.
 */
class AA {
	int a = 10; // 멤버(인스턴스) 변수
	static int b = 100; // 클래스(정적) 변수 - 클래스가 로딩 되는 순간 만들어짐.
	public void test(int c) {
		int d = 200; // 지역변수
	}
}
public class Exam_01 {
	public static void main(String[] args) {
		AA aa = new AA(); // 객체 생성 (a라는 멤버(인스턴스)변수가 이 때 생성됨(자동초기화)) - 지역 변수는 호출 될 때 생성되고 사라짐.
		System.out.println("a = " + aa.a); // 객체를 생성하면 접근가능.
		System.out.println("b = " + AA.b); // 클래스가 로딩 되는 순간 만들어지기 떄문에 객체 생성 없이도 에러가 안나고 사용가능.
		System.out.println("b = " + aa.b); // 객체를 이용해서도 접근가능.
		//System.out.println("c = " + aa.c); // 객체를 생성 해도 메소드를 호출 할 때 생성되기 때문에 객체 생성해도 접근 불가능.
		aa.a = 300;
		System.out.println("a = " + aa.a); //aa의 a값은 변경되지만 정적변수 b는 변하지 않음.
		AA.b = -100;
		AA ab = new AA(); // 정적 변수 c는 객체를 두개 만들어도 하나로 여러 객체가 공유해서 사용함.
		System.out.println("a = " + ab.a);
		System.out.println("b = " + AA.b);
		System.out.println("b = " + ab.b);
		//System.out.println("c = " + aa.c);
	}
}