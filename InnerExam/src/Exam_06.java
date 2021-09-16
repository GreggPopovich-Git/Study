// 예외 처리
public class Exam_06 {

	public static void main(String[] args) {
		try {
		int[] arr = {1,2,3,4,5};
		System.out.println("arr[0] : " + arr[0]);
		System.out.println("arr[5] : " + arr[5]);
		}catch(ArrayIndexOutOfBoundsException e) {
			//System.out.println("배열 첨자오류 : " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
