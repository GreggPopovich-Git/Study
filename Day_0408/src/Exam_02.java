/* 	1
 * 	2  3
 * 	4  5  6
 *  7  8  9  10
 *  11 12 13 14 15
 * 
 */
public class Exam_02 {
	public static void main(String[] args) {
		int a[][] = new int[5][5];
		int cnt = 0;
		//데이터 입력
		for (int x = 0; x < a.length; x++) {
			for (int y = 0; y <= x; y++) {
				cnt++;
				a[x][y] = cnt;
			}
		}
		//데이터 출력
		for (int x = 0; x < a.length; x++) {
			for (int y = 0; y < a[x].length; y++) {
				if (a[x][y] == 0)
					break;
				System.out.print(a[x][y] + "\t");
			}
			System.out.println();
		}

	}

}
