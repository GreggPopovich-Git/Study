/* 1
 * 3  2
 * 6  5  4
 * 10 9  8  7
 * 15 14 13 12 11
 */
public class Exam_04 {
	public static void main(String[] args) {
		int a[][] = new int[5][5];
		int cnt = 0;
		//데이터 입력
		for (int x = 0; x < a.length; x++) {
			for (int y = x; y >= 0; y--) {
				cnt++;
				a[x][y] = cnt;
			}
		}
		//데이터 출력
		for (int x = 0; x < a.length; x++) {
			for (int y = 0; y < a[x].length; y++) {
				if (a[x][y] != 0)
				System.out.print(a[x][y] + "\t");
			}
			System.out.println();
		}

	}

}
