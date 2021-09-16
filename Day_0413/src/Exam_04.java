/* 1. 리턴타입 X, 매개변수 X
 * 2. 리턴타입 X, 매개변수 O
 * 3. 리턴타입 O, 매개변수 X
 * 4. 리턴타입 O, 매개변수 O
 */
public class Exam_04 {
	static void test1() {
		System.out.println("Hello World");
	}
	static void test2(int a[]) {
		for (int x = 0; x < a.length; x++) {
			System.out.print(a[x] + "\t");
		}
	}
	static int test3() {
		int s = 0;
		for (int x = 1; x <= 10; x++) {
			s += x;
			System.out.print(x + "\t");
		}
		return s;
	}
	static int test4(int a) {
		int tot = 0;
		for (int x = 1; x <= a; x++) {
			tot += x;
			System.out.print(x + "\t");
		}
		return tot;
	}
	public static void main(String[] args) {
		test1();
		
		int score[] = {10,20,30,40,50,60,70,80,90};
		test2(score);
		
		System.out.println(test3());
		System.out.println();
		test4(10);
		System.out.println();
		System.out.println(test4(10));
	}

}