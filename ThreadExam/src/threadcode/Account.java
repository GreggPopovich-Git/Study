package threadcode;

public class Account {
	String accountNO; // 계좌번호
	String ownerName; // 이름
	int balance; // 잔액
	public Account(String no, String name, int money) {
		accountNO = no;
		ownerName = name;
		balance = money;
	}
	// 입금
	void deposit(int amount) {
		balance += amount;
	}
	// 출금
	int withdraw(int amount) {
		if(balance < amount) {
			return 0;
		}
		balance -= amount;
		return amount;
	}
}