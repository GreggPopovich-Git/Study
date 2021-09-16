/* method type : 반환형[메소드이름(매개변수) + return]
 * 
 */
class DD {
	
	public void test_01() {
		// 리턴타입 X, 매개변수 X
		int tot = 0;
		for(int x = 1; x <= 10; x++)
			tot += x;
		System.out.println("1~10의 합 : " + tot);
		return;
	}
	public void test_02(int a, int b) {
		// 리턴타입 X, 매개변수 O
		int tot = 0;
		for (int x = a; x <= b; x++)
			tot += x;
		System.out.println(a + "~"+ b + "의 합 : " + tot);
	}
	public int test_03() {
		// 리턴타입 O, 매개변수 X
		int tot = 0;
		for (int x = 1; x <= 10; x++)
			tot += x;
		return tot;
	}
	public int test_04(int a, int b) {
		// 리턴타입 O, 매개변수 O
		int tot = 0;
		for (int x = a; x <= b; x++)
			tot += x;
		return tot;
	}
}
public class Exam_04 {

	public static void main(String[] args) {
		DD dd = new DD();
		dd.test_01();
		dd.test_02(10, 20);
		int tot = dd.test_03();
		System.out.println("1~10의 합 : " + tot);
		int a = 1, b = 10;
		System.out.println(a + "~" + b + "의 합 : " + dd.test_04(a, b));
		
	}

}