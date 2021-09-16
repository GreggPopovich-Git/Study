
public class Exam_04 {
	public static void main(String[] args) {
		int hak[][] = {{1,79,88,95,77,0},{4,89,87,91,70,0},{5,88,85,90,70,0},
				{3,70,80,90,70,0},{2,77,78,85,87,0}};

		//입력된 자료 출력
		System.out.println("번호\t국어\t영어\t수학\t전산");
		for (int x = 0; x < hak.length; x++) {
			for (int y = 0; y < hak[x].length-1; y++) {
				System.out.print(hak[x][y] + "\t");
			}
			System.out.println();
		}
		//국어점수를 기준으로 석차 구하기
		for (int x = 0; x < hak.length; x++) {
			hak[x][5] = 1;
			for (int y = 0; y < hak.length; y++) {
				if (hak[x][1] < hak[y][1]) 
					hak[x][5]++;
			}
		}
		
		System.out.println("------------------SORT DATA---------------------");
		for (int x = 0; x < hak.length-1; x++) {
			for (int y = x+1; y < hak.length; y++) {
				if (hak[x][0] > hak[y][0]) {
					for (int k = 0; k < hak.length; k++) {
						int temp = hak[x][k];
						hak[x][k] = hak[y][k];
						hak[y][k] = temp;
					}
				}
			}
		}
		
		
		System.out.println("번호\t국어\t영어\t수학\t전산\t석차");
		for (int x = 0; x < hak.length; x++) {
			for (int y = 0; y < hak[x].length; y++) {
				System.out.print(hak[x][y] + "\t");
			}
			System.out.println();
		}
	}
}
