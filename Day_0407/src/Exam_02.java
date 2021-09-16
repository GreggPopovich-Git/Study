import java.util.Scanner;

/* 배열에 저장된 데이터 검색
 * 2. Binery Search (2진 검색)
 * 	- 오름차순 또는 내림차순으로 정렬 되어 있어야 함.
 * 	- 모든 데이터를 절반으로 나눠서 검색.
 * 	- 0번째 인덱스를 Low, 마지막 인덱스를 High로 함.
 * 	- m = (Low + high) / 2  <- 중간 인덱스를 찾음.
 * 	- 찾으려는 값과 arr[m]과 비교해서 High의 위치를 바꿈.
 */
public class Exam_02 {
	public static void main(String[] args) {
		int arr[] = {88,90,56,55,34,52,40,88,75,66};
		Scanner scn = new Scanner(System.in);
		// 배열 데이터 출력
		System.out.println("정렬 전 원본 데이터 배열 arr[]");
		System.out.println("1\t2\t3\t4\t5\t6\t7\t8\t9\t10");
		for (int x = 0; x < arr.length; x++) {
			System.out.print(arr[x] + "\t");
		}
		//배열 복사
		int arr2[] = arr.clone();
		//오름차순 Sort
		for (int x = 0; x < arr2.length-1; x++) {
			boolean flag = true;
			int n = arr2.length-x-1;
			for (int y = 0; y < n; y++) {
				if (arr2[y] > arr2[y+1]) {
					int temp = arr2[y];
					arr2[y] = arr2[y+1];
					arr2[y+1] = temp;
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
		System.out.println("\n\n오름차순 정렬된 데이터 배열 arr2[]");
		System.out.println("1\t2\t3\t4\t5\t6\t7\t8\t9\t10");
		for (int x = 0; x < arr.length; x++) {
			System.out.print(arr2[x] + "\t");
		}
		System.out.print("\n------------------------------------------------------------");
		while (true) {
			System.out.print("\n검색데이터 입력 : ");
			int num = scn.nextInt();
			if (num == -99)
				break;
			int low = 0;
			int high = arr2.length-1;
			boolean flag = true;
			while (low <= high) {
				int mid = (low + high)/2;
				if (arr2[mid] == num) {
					//검색성공
					System.out.println(num + "는" + (mid+1) + "번째 있음.");
					flag = false;
					break;
				}
				else if (arr2[mid] > num) {
					high = mid - 1;
				}
				else {
					low = mid + 1;
				}
			}
			if (flag)
				System.out.println("데이터가 없습니다.");
			
		}
		scn.close();

	}

}
