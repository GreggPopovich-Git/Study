
public class Exam_05 {
	
	public static void main(String[] args) {
		int score[] = {90,77,85,95,55,88,77,65,45,30,78,82};
		//Sort 전 데이터 출력
		dataPrint(score);
		//Sort
		dataSort(score);
		//Sort 후 데이터 출력
		dataPrint(score);
	}
	//배열 data 출력
	static void dataPrint(int arr[]) {
		System.out.print("Data : \t");
		for (int x = 0; x < arr.length; x++) {
			System.out.print(arr[x] + "\t");
		}
		System.out.println();
	}
	//Sort
	static void dataSort(int[] arr) {
		for (int x = 0; x < arr.length-1; x++) {
			for (int y = x+1; y < arr.length; y++) {
				if(arr[x] > arr[y]) {
					int temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;
				}
			}
		}
	}
	
}
