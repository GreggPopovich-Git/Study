// 거품정렬 (Bubble Sort)와 flag를 이용해서 이미 정렬이 되어있는 부분을 하지 않고 건너 뜀.

public class Exam_06 {
	public static void main(String[] args) {
		int score[] = {70,90,80,77,85,50,60};
		int length = score.length;
		System.out.print("Source : ");
		for (int x = 0; x < length; x++) {
			System.out.print(score[x] + "\t");
		}
		System.out.println();
		// 오름차순으로 Bubble Sort
		for (int x = 0; x < score.length-1; x++) {
			boolean flag = true;
			int n = length-x-1;
			for (int y = 0; y < n; y++) {
				if (score[y] > score[y+1]) {
					int temp = score[y];
					score[y] = score[y+1];
					score[y+1] = temp;
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
		
		System.out.print("Sort   : ");
		for (int x = 0; x < length; x++) {
			System.out.print(score[x] + "\t");
		}

	}

}
