
public class Exam_03 {
	// method 호출 : Call By Value (값에 의한 호출)
	static void swap(int a, int b) {
		int c = a;
		a = b;
		b = c;
	}
	// method 호출 : 참조에 의한 호출
	static void swapArr(int arr[]) {
		int c = arr[0];
		arr[0] = arr[1];
		arr[1] = c;
	}
	
	public static void main(String[] args) {
		int a = 100, b = 200;
		System.out.println("a = " + a + "\tb = " + b);
		
		swap(a, b);
		System.out.println("a = " + a + "\tb = " + b);
		
		int arr[] = {100, 200};
		System.out.println("arr[0] = " + arr[0] + "\tarr[1] = " + arr[1]);
		
		swapArr(arr);
		System.out.println("arr[0] = " + arr[0] + "\tarr[1] = " + arr[1]);
	}

}