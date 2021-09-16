package exam02;
interface Control { // 인터페이스는 다형성을 위해 만드는 것 - 구현하여 클래스를 여러가지로 만들 수 있음.
	int MAX_VOLUME = 10; // public static final 생략. public이 기본
	int MIN_VOLUME = 0;
	
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	default void setMute(boolean mute) { // 필수는 아니지만 overrides 할 수 있음.
		if(mute) {
			System.out.println("무음처리합니다.");
		}
		else {
			System.out.println("무음해제합니다.");
		}
	}
	static void changeBattery() {
		System.out.println("배터리를 교체합니다.");
	}
}
// 구현 클래스 (implements) - 상속과 같은 개념인데 상속은 아님. 상속 했다고 하면 상속 받아서 또다른 인터페이스를 생성한다는 뜻.
class Radio implements Control {
	int volume;
	
	@Override
	public void turnOn() {
		System.out.println("라디오를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("라디오를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		if(volume > Control.MAX_VOLUME)
			this.volume = Control.MAX_VOLUME;
		else if (volume < Control.MIN_VOLUME)
			this.volume = Control.MIN_VOLUME;
		else
			this.volume = volume;
		System.out.println("현재 라디오 볼륨 : " + this.volume);
	}
	
}
public class Exam_06 {

	public static void main(String[] args) {
		Radio radio = new Radio();
		TV tv = new TV();
		
		Control control; // 인터페이스를 이용한 변수 설정. 인터페이스 변수를 이용해서 인터페이스를 구현해서 만든 클래스를 다 접근 할 수 있음.
		control = new Radio();
		control.turnOn();
		control.setVolume(11);
		control.setMute(true);
		control.turnOff();
		Control.changeBattery();
		control = new TV();
		control.turnOn();
		control.setVolume(-5);
		control.turnOff();
	}
}

class TV implements Control {
	int volume;
	
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		if(volume > Control.MAX_VOLUME)
			this.volume = Control.MAX_VOLUME;
		else if (volume < Control.MIN_VOLUME)
			this.volume = Control.MIN_VOLUME;
		else
			this.volume = volume;
		System.out.println("현재 라디오 볼륨 : " + this.volume);
	}
}