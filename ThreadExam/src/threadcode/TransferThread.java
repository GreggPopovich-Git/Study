package threadcode;

public class TransferThread extends Thread {
	SharedArea sharedArea;
	public TransferThread(SharedArea area) {
		sharedArea = area;
	}
	@Override
	public void run() {
		for(int x = 0; x < 10; x++) {
			synchronized (sharedArea) { // 공유영역을 ( )에 적어줌
			sharedArea.account1.withdraw(100);
			System.out.print(sharedArea.account1.ownerName + "계좌 : 100만원 인출됨, ");
			
			sharedArea.account2.deposit(100);
			System.out.println(sharedArea.account2.ownerName + "계좌 : 100만원 지급됨");
			}
		}
	}
}
