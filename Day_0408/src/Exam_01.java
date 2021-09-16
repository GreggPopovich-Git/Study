// 2차원 배열 처리
public class Exam_01 {
	public static void main(String[] args) {
		int mat[][] = new int[5][5];
		//배열에 데이터 입력
		int cnt = 0;
		for (int x = 0; x < mat.length; x++) {
			for (int y = 0; y < mat[x].length; y++) {
				cnt++;
				mat[x][y] = cnt;
				//mat[x][y] = ++cnt;
				System.out.print(mat[x][y] + "\t");
			}
			System.out.print("\n"); //System.out.println();
		}

	}

}
