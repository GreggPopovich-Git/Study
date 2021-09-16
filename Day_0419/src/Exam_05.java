class EE {
	// 1. 두수의 합
	public void sum(int a, int b) {
		
	}
	// 2. 세수의 합 (매개변수의 수가 다름)
	public void sum(int a, int b, int c) {
		
	}
	// 3. 두수의 합 (타입이 다름)
	public void sum(int a, double b) {
	
	}
	// 4. 여러개의 인수
	public void sum(int ... b) { // 가변인자 (배열방식과 같음)
		int tot = 0;
		for (int x = 0; x < b.length; x++)
			tot += b[x];
		System.out.println("1~" + b.length + "의 합 : " + tot);
	}
	// 5. 배열을 매개변수로
	public void sum2(int a[]) { // 배열
		int tot = 0;
		for (int x = 0; x < a.length; x++)
			tot += a[x];
		System.out.println("1~" + a.length + "의 합 : " + tot);
	}
}
public class Exam_05 {
	public static void main(String[] a) {
		EE ee = new EE();
		ee.sum(1,2);
		ee.sum(1,2,3);
		ee.sum(1,2.5);
		ee.sum(1,2,3,4,5);
		ee.sum(1,2,3,4,5,6,7,8,9,10);
		//ee.sum2(new int[] {1,2,3,4,5,6,7});
		int ss[] = {1,2,3,4,5,6,7};
		ee.sum2(ss);
		
	}
}
