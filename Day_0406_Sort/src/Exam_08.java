/* int bun[] = {1,2,3,4,5,6,7,8,9}
 * int score[] = {95,88,79,90,88,70,93,65,85}
 * int rank[] = new int[bun.length]
 * [출력 형식-1]
 * 번호 : 1     2     3     4     5     6     7     8     9
 * 점수 : 95   88    79    90    88    70    93    65    85
 * 석차 : 1     4     7     3     4     8     2     9     6
 * 
 * [출력 형식-2] : 석차를 기준으로 오름차순 정렬 후 출력
 * 번호 : 1     7     4     2     5     9     3     6     8
 * 점수 : 95   93    90    88    88    85    79    70    65
 * 석차 : 1     2     3     4     4     6     7     8     9
 * 
 */
public class Exam_08 {
	public static void main(String[] args) {
		int bun[] = {1,2,3,4,5,6,7,8,9};
		int score[] = {95,88,79,90,88,70,93,65,85};
		int rank[] = new int[bun.length];
		
		for (int i = 0; i < bun.length; i++) {
			rank[i] = 1;
			for (int j = 0; j < bun.length; j++) {
				if (score[i] < score[j])
					rank[i]++;
			}
		}
		System.out.print("번호 : ");
		for (int x = 0; x < rank.length; x++) {
			System.out.print(bun[x] + "  \t");
		}
		System.out.println();
		System.out.print("점수 : ");
		for (int x = 0; x < rank.length; x++) {
			System.out.print(score[x] + "  \t");
		}
		System.out.println();
		System.out.print("석차 : ");
		for (int x = 0; x < rank.length; x++) {
			System.out.print(rank[x] + "  \t");
		}
		System.out.println();
		
		for (int i = 0; i < score.length-1; i++) {
			boolean flag = true;
			for (int j = 0; j < score.length-i-1; j++) {
				if (rank[j] > rank[j+1]) {
					int temp1 = score[j];
					int temp2 = bun[j];
					int temp3 = rank[j];
					score[j] = score[j+1];
					bun[j] = bun[j+1];
					rank[j] = rank[j+1];
					score[j+1] = temp1;
					bun[j+1] = temp2;
					rank[j+1] = temp3;
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
		System.out.println();
		System.out.print("번호 : ");
		for (int x = 0; x < rank.length; x++) {
			System.out.print(bun[x] + "  \t");
		}
		System.out.println();
		System.out.print("점수 : ");
		for (int x = 0; x < rank.length; x++) {
			System.out.print(score[x] + "  \t");
		}
		System.out.println();
		System.out.print("석차 : ");
		for (int x = 0; x < rank.length; x++) {
			System.out.print(rank[x] + "  \t");
		}
		System.out.println();

	}

}
