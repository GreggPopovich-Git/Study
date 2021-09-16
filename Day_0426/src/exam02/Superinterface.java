package exam02;
// interface에 들어갈 수 있는 것은 정해져 있음. 4가지 이외에는 어떤 것도 사용 불가능.
// 1. static final 변수 = 값; // 상수
// 2. 추상 메소드(); public abstract를 선언하지 않아도 자동으로 추상메소드가 생성됨.
// 3. public default method() {} // default : 기본기능 탑재하기 위해 추가
// 4. public static type method() {} // static : 
public interface Superinterface { // 인터페이스를 이용해서 클래스를 만든 것이 구현 클래스
	static final int MAX = 100;
	void exam(); //public abstract void exam();
	void sum(int x);
}