/* 2차원 배열 (행,열 구조)
 * 
 */
public class Exam_03 {
	public static void main(String[] args) {
		//int a[] = {1,2,3,4,5}; //1차원배열의 선언과 원하는 값 할당
		//int a[] = new int[5]; //1차원 배열의 선언과 초기값 0으로 할당
		int arr2[][] = new int[5][5]; //5행 5열 2차원 배열
		System.out.println("arr2 배열의 row : " + arr2.length);
		System.out.println("arr2 배열의 col[0] : " + arr2[0].length);
		System.out.println("arr2 배열의 col[1] : " + arr2[1].length);
		int arr[][] = {{1,90,88,70,0},{2,88,77,88,0},
				{3,90,70,85,0},{4,95,89,90,0},{5,90,87,89,0}};
		System.out.println("arr 배열의 row : " + arr.length);
		System.out.println("arr 배열의 col[0] : " + arr[0].length);
		System.out.println("arr 배열의 col[1] : " + arr[1].length);
		//총점 계산

		for (int x = 0; x < arr.length; x++) {
			arr[x][4] = arr[x][1] + arr[x][2] + arr[x][3];
		}
/*
		for (int x = 0; x < arr.length; x++) {
			for (int y = 1; y < 4; y++)
			arr[x][4] += arr[x][y];
		}
*/		
		System.out.println("번호\t국어\t영어\t수학\t총점");
		for (int x = 0; x < arr.length; x++) { //줄(row)
			for (int y = 0; y < arr[x].length; y++) { //줄(row)당 칸수(col)
				System.out.print(arr[x][y] + "\t");
			}
			System.out.println();
		}
		
	}

}
