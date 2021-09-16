package threadmethod;
// 공유영역
public class SharedArea {
	Account account1;
	Account account2;
	
	// 동기화 메소드 입출금
	public synchronized void transfer(int amount) {
		account1.withdraw(amount);
		System.out.print(account1.ownerName + "계좌 100만원 이출됨, ");
		account2.deposit(amount);
		System.out.println(account2.ownerName + "계좌 100만원 입금됨");
	}
	// 합계계산
	public synchronized int getTotal() {
		return account1.balance + account2.balance;
	}
}