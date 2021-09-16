package threadtest;
class Cat extends Thread {
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
class Dog extends Thread { // 쓰레드를 상속 받아서 클래스를 생성.
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
public class Exam_02 {
	public static void main(String[] args) {
		Cat cat = new Cat();
		Dog dog = new Dog();
		cat.start(); // start 메소드를 호출하면 run 메소드를 실행함.
		dog.start();
	}
}