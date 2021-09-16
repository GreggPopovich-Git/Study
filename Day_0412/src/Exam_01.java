import java.util.Scanner;

public class Exam_01 {
	
	static void costInput(String name[], int arr[][]) { //입력메소드
		Scanner scn = new Scanner(System.in);
		for (int i = 0; i < arr.length-1; i++) {
			System.out.print("사원 등록 : ");
			String nameInput = scn.next();
			if (nameInput.equalsIgnoreCase("end"))
				break;
			name[i] = nameInput;
			arr[i][0] = scn.nextInt();
		}
		scn.close();
	}
	static void calculation(int arr[][]) { //계산메소드
		for (int i = 0; i < arr.length-1; i++) {
			int money = 50000;
			int temp = arr[i][0];
			for (int j = 1; j < arr[i].length; j++) {
				if (temp == 0)
					break;
				arr[i][j] = temp / money;
				temp %= money;
				if (j % 2 == 1)
					money /= 5;
				else
					money /= 2;
			}
		}
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				arr[arr.length-1][j] += arr[i][j];
			}
		}
	}
	static void dataPrint(String name[], int arr[][]) { //출력메소드
		System.out.println("성명\t출장비\t50,000원\t10,000원\t5,000원\t1,000원\t500원\t100원\t50원\t10원\t5원\t1원");
		for (int i = 0; i < name.length; i++) {
			if (name[i] == null)
				continue;
			System.out.print(name[i] + "\t");
			for (int j = 0; j < arr[i].length; j++) {
				if (i == arr.length-1 && j == 0)
					continue;
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		String[] name = new String[100];
		int[][] cost = new int[100][11];
		name[name.length-1] = "전체 화폐 매수 : ";
		//Data Input
		costInput(name, cost);
		//Data Calculation
		calculation(cost);
		//Data Output
		dataPrint(name,cost);
 	}
}