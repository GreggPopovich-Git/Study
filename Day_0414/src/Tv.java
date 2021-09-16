/* OOP
 * Object(객체) : 유형, 무형의 모든 것 -> 다른말로 (인스턴스)
 * Entity(개체) : 속성
 * Class : 231p 참조 - 객체를 만들기 위한 설계도
 * Message : 객체와 객체간의 통신
 * 
 * 객체
 * 1. 개체 (Entity)
 * 2. 속성 -> 변수
 * 3. 기능(메소드)
 * 
 * 3단계
 * 1. 객체 모델링(추상화) - 기능, 속성 정의
 * 2. 클랙스 작성 - 객체 모델링 한 것을 바탕으로 코드(설계도) 작성
 * 3. 객체의 생성 및 사용
 * 
 * 접근제어 (정보은닉, 외부접근제한)
 * public - 공용
 * protected - 상속관계에 있을 때만 접근가능
 * private
 * default - 같은 폴더 안에서만 접근가능
 */

public class Tv {
	// 속성정의 (변수)
	String color;
	boolean power;
	// 기능 (메소드)
	public void power() {
		power = !power;
	}
	// 생성자 (클래스 이름과 똑같은 메소드)
	Tv(){}
}
