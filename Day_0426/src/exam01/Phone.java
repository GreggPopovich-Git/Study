package exam01;

public abstract class Phone {
	public String pName;	
	public Phone(String pName) {
		this.pName = pName;
	}
	public void turnNo() {
		System.out.println("폰 전원을 켭니다");
	}
	public void turnOff() {
		System.out.println("폰 전원을 끕니다");
	}
	public abstract void bellSound();
}