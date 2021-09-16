package exam02;
class Parent {
	int x = 100;
}
class Child extends Parent {
	//int y = 200;
}
//instanceof 연산자
public class Exam_07 {
	public static void conversion1(Parent parent) { // 다운 캐스팅
		if (parent instanceof Child) { //매개변수 instanceof 클래스이름
			Child child = (Child) parent;
			System.out.println("Child로 변환 가능");
		}
		else {
			System.out.println("Child로 변환 불가");
		}
	}
	public static void conversion2(Parent parent) {
			Child child = (Child) parent;
			System.out.println("Child로 변환 가능");
	}
	public static void main(String[] args) {
		Parent p1 = new Parent();
		Parent p2 = new Child(); // 업캐스팅
		
		conversion1(p1);
	}
}