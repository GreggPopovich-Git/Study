
public class Exam_03 {
	public static void main(String[] args) {
		int score[] = new int[5];
		score[0] = 10;
		score[1] = 20;
		score[2] = 30;
		score[3] = 40;
		score[4] = 50;
		
		int arr[] = {10,20,30,40,50};
		System.out.print("Score : ");
		System.out.print(score[0] + "\t");
		System.out.print(score[1] + "\t");
		System.out.print(score[2] + "\t");
		System.out.print(score[3] + "\t");
		System.out.print(score[4] + "\t");
		
		System.out.print("arr : " + arr.length);
		for (int x = 0; x < arr.length; x++) {
			System.out.print(arr[x] + "\t");
		}
	}

}
