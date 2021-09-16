package threadmethod;

public class TransferThread extends Thread {
	SharedArea sharedArea;
	public TransferThread(SharedArea area) {
		sharedArea = area;
	}
	@Override
	public void run() {
		for(int x = 0; x < 10; x++) {
			sharedArea.transfer(100);
		}
	}
}
