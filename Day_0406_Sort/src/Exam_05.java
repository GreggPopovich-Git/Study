// 삽입정렬

public class Exam_05 {
	public static void main(String[] args) {
		int score[] = {70,90,80,77,85,50,60};
		int length = score.length;
		System.out.print("Source : ");
		for (int x = 0; x < length; x++) {
			System.out.print(score[x] + "\t");
		}
		System.out.println();
		// 오름차순으로 sort
		for (int x = 1; x < score.length; x++) {
			int key = score[x];
			int m = x-1, y;
			for (y = m; y >= 0; y--) {
				if (key < score[y]) {
					score[y+1] = score[y];
				}
				else {
					break;
				}
			}
			score[y+1] = key;
		}
		
		System.out.print("Sort   : ");
		for (int x = 0; x < length; x++) {
			System.out.print(score[x] + "\t");
		}

	}

}
