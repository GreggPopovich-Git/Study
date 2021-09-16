// 순위(석차) - 모든 데이터와 비교

public class Exam_07 {
	public static void main(String[] args) {
		int score[] = {70,90,80,77,85,50,60};
		int rank[] = new int[score.length];
		int length = score.length;
		
		System.out.print("Source : ");
		for (int x = 0; x < length; x++) {
			System.out.print(score[x] + "\t");
		}
		System.out.println();
/*
		//석차계산
		for (int x = 0; x < score.length; x++) {
			int r = 1;
			for (int y = 0; y < score.length; y++) {
				if (score[x] < score[y])
					r++;
			}
			rank[x] = r;
		}
*/
		//석차계산
		for (int x = 0; x < score.length; x++) {
			rank[x] = 1;
			for (int y = 0; y < score.length; y++) {
				if (score[x] < score[y])
					rank[x]++;
			}
		}
		System.out.print("Ranking : ");
		for (int x = 0; x < rank.length; x++) {
			System.out.print(rank[x] + "\t");
		}
		
	}

}
