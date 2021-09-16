package nothread;
class Cat {
	void run() {
		for (int x = 0; x < 10; x++)
			System.out.println("야옹");
	}
}

class Dog {
	void run() {
		for (int x = 0; x < 10; x++)
			System.out.println("멍멍");
	}
}

public class Exam_01 {
	public static void main(String[] args) {
		Cat cat = new Cat();
		Dog dog = new Dog();
		cat.run();
		dog.run();
	}

}
