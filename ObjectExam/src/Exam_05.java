import java.util.Arrays;

// clone() : 자신을 복제하여 새로운 인스턴스 생성
// 복제를 하기 위해서는 Cloneable 인터페이스를 구현한 클래스이어야 함.
// 배열, 컬렉션 프레임워크 등이 복제 가능함.
class AAA implements Cloneable {
	
}
public class Exam_05 {
	static void arrSort(int temp[]) {
		for (int x = 0; x < temp.length-1; x++) {
			for(int y = x + 1; y < temp.length; y++) {
				if (temp[x] > temp[y]) {
					int imsi = temp[x];
					temp[x] = temp[y];
					temp[y] = imsi;
				}
			}
		}
	}
	public static void main(String[] args) {
		int arr[] = {20,10,50,30,40};
		int temp[] = arr.clone();
		
		arrSort(arr);
		System.out.println("Sort 전 : " + Arrays.toString(temp));
		System.out.println("Sort 후 : " + Arrays.toString(arr));
	}

}