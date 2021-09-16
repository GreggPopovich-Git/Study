package exam;

public class Sawon {
	String name;
	int pay;
	int money[] = new int[10];
	
	public Sawon(){}
	public Sawon(String name, int pay) {
		this.name = name;
		this.pay = pay;
		moneyCnt();
	}
	//화폐매수 계산 메소드 정의
	private void moneyCnt() {
		int cash = 50000;
		int temp = pay;
		for (int i = 0; i < money.length; i++) {
			if (temp == 0)
				break;
			money[i] = temp / cash;
			temp %= cash;
			if (i % 2 == 0)
				cash /= 5;
			else
				cash /= 2;
		}
	}
	//출력 메소드
	public void print() {
		System.out.print(name + "\t" + pay + "\t");
		for (int i = 0; i < money.length; i++) {
			System.out.print(money[i] + "\t");
		}
		System.out.println();
	}
	
}
