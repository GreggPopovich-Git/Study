
public class Exam_01 {
	public static void main(String[] args) {
		int score[][] = new int[5][5];
		//입력작업
		int cnt = 0;
		for (int x = 0; x < score.length-1; x++) {
			for (int y = 0; y < score[x].length-1; y++) {
				cnt++;
				score[x][y] = cnt;
				score[x][score[x].length-1] += cnt;
				score[score.length-1][y] += cnt;
				score[score.length-1][score[x].length-1] += cnt;
			}
		}
		//출력작업
		for (int x = 0; x < score.length; x++) {
			for (int y = 0; y < score[x].length; y++) {
				System.out.print(score[x][y] + "\t");
			}
			System.out.println();
		}

	}

}
