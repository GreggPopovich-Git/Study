package threadmethod;

public class AccountRun {

	public static void main(String[] args) {
		SharedArea area = new SharedArea();
		area.account1 = new Account("111", "김학생", 2000);
		area.account2 = new Account("222", "박학생", 1000);
		
		TransferThread th1 = new TransferThread(area);
		PrintThread th2 = new PrintThread(area);
		
		th1.start();
		th2.start();
	}

}