package exam01;

public class Exam_04 {

	public static void main(String[] args) {
		// Phone phone = new Phone(); 추상클래스는 객체 생성할 수 없음.
		SmartPhone sPhone1 = new SmartPhone();
		sPhone1.turnNo();
		sPhone1.bellSound();
		sPhone1.turnOff();
		
		SmartPhone sPhone2 = new SmartPhone("LG");
		sPhone2.turnNo();
		sPhone2.bellSound();
		sPhone2.turnOff();
	}

}