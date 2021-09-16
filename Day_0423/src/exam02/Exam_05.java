package exam02;

import exam01.Korea;
class SubKorea extends Korea {
	String name = "김학생";
	
	void test() {
		System.out.println("name = " + super.name);
		System.out.println("name = " + name);
		exam();
	}
	protected void exam() {
		super.exam();
		System.out.println("name = " + name);
	}
}
public class Exam_05 {

	public static void main(String[] args) {
		Korea k = new Korea();
		//k.exam();
		//k.test();
		SubKorea sk = new SubKorea();
		sk.test();
		sk.exam();
	}
}