import java.util.Arrays;

public class Exam_06 {

	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{4,5,6}};
		int[][] temp = arr.clone();
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(temp));
		System.out.println("------------------------------");
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(temp[0]));
		System.out.println("------------------------------");
		System.out.println(Arrays.toString(arr[1]));
		System.out.println(Arrays.toString(temp[1]));
		System.out.println("------------------------------");
		for (int x = 0; x < arr.length; x++) {
			System.out.print("[");
			for (int y = 0; y < arr[x].length; y++) {
				System.out.print(arr[x][y] + ", ");
			}
			System.out.println("]");
		}
		
	}

}
