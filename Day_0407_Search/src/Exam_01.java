import java.util.Scanner;

/* 배열에 저장된 데이터 검색
 * 1. Linear Search(선형검색)
 * 
 */
public class Exam_01 {
	public static void main(String[] args) {
		int arr[] = {88,90,56,55,34,52,40,88,75,66};
		Scanner scn = new Scanner(System.in);
		// 배열 데이터 출력
		System.out.println("1\t2\t3\t4\t5\t6\t7\t8\t9\t10");
		for (int x = 0; x < arr.length; x++) {
			System.out.print(arr[x] + "\t");
		}
		System.out.print("\n------------------------------------------------------------");
		while (true) {
			System.out.print("\n검색데이터 입력 : ");
			int num = scn.nextInt();
			if (num == -99)
				break;
			boolean flag = true;
			for (int i = 0; i < arr.length; i++) {
				if (num == arr[i]) {
					System.out.println(num + "데이터가" + (i+1) + "번째에 있습니다.");
					flag = false;
					break;
				}
				
			}
			if (flag)
				System.out.println("데이터가 없습니다.");
			
		}
		scn.close();

	}

}
