package runnabletest;

class Cat implements Runnable {
	@Override
	public void run() {
		for (int x = 0; x < 10; x++) {
			System.out.println("야옹");
			try {
				Thread.sleep(500); // 0.5초
			} catch (Exception e) {
			}
		}
	}
}
class Dog implements Runnable {
	@Override
	public void run() {
		for (int x = 0; x < 10; x++) {
			System.out.println("멍멍");
			try {
				Thread.sleep(500); // 0.5초
			} catch (Exception e) {
			}
		}
	}
}
public class Exam_03 {

	public static void main(String[] args) {
		Cat cat = new Cat();
		Thread t1 = new Thread(cat);
		Thread t2 = new Thread(new Dog());
		t1.start();
		t2.start();
	}

}
