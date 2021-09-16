/* 	1  2  3  4  5
 * 	10 9  8  7  6
 * 	11 12 13 14 15
 *  20 19 18 17 16
 *  21 22 23 24 25
 * 
 */
public class Exam_05 {
	public static void main(String[] args) {
		int a[][] = new int[5][5];
		int cnt = 0;
		//데이터 입력
		for (int x = 0; x < a.length; x++) {
			if (x % 2 == 0) {
				for (int y = 0; y < a[x].length; y++) {
					cnt++;
					a[x][y] = cnt;
				}
			}
			else {
				for (int y = 4; y >= 0; y--) {
					cnt++;
					a[x][y] = cnt;
				}
			}
		}
		//데이터 출력
		for (int x = 0; x < a.length; x++) {
			for (int y = 0; y < a[x].length; y++) {
				System.out.print(a[x][y] + "\t");
			}
			System.out.println();
		}

	}

}
