package threadtest;
/*	동기화 - 동기화 메소드(불안정-오류있음), 동기화 코드블럭(이걸 써라 안정적이다)
 *  공유영역(임계영역)
 */
class PriThread extends Thread {
	public PriThread(String name) {
		setName(name);
	}
	@Override
	public void run() {
		for(int x = 0; x < 200000000; x++) {
		}
		System.out.println(getName());
	}
}
public class Exam_06 {

	public static void main(String[] args) {
		for(int x = 1; x <= 10; x++) {
			Thread th1 = new PriThread("Thread" + x);
			if(x != 10) {
				th1.setPriority(Thread.MIN_PRIORITY);
			}
			else {
				th1.setPriority(Thread.MAX_PRIORITY);
			}
			th1.start();
		}

	}

}