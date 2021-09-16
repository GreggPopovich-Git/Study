package exam01;
/* 추상(abstract)클래스 - 미완성 설계도
 * 
 * 
 */
abstract class AA {
	int x = 10;
	int y = 20;
	
	public void print() {
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}
}
class AAA extends AA {
	
}
public class Exam_01 {
	public static void main(String[] args) {
		AAA a = new AAA();
		
	}

}
