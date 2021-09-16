package threadmethod;

public class PrintThread extends Thread {
	SharedArea sharedArea;
	public PrintThread(SharedArea area) {
		sharedArea = area;
	}
	@Override
	public void run() {
		for(int x = 0; x < 3; x++) {
			int sum = sharedArea.getTotal();
			System.out.println("계좌 잔액 합계 : " + sum);
		}
		try {
			Thread.sleep(2);
		}catch(Exception e) {}
	}
}
