package exam01;

public class SmartPhone extends Phone {
	public SmartPhone() {
		super("삼성");
	}
	
	public SmartPhone(String pName) {
		super(pName);
	}

	@Override
	public void bellSound() {
		System.out.println("쿠크루삥뽕");
	}

}