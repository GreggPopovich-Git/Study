
public class Exam_03 {
	public static void main(String[] args) {
		int hak[][] = {{1,79,88,95,77,0,0},{4,89,87,91,70,0,0},{5,88,85,90,70,0,0},
				{3,70,80,90,70,0,0},{2,77,78,85,87,0,0}};
		int tot[] = new int[5];
		//총점, 과목별 계산
		for (int x = 0; x < hak.length; x++) {
			for (int y = 0; y < hak[x].length-2; y++) {
				if (y != 0) {
					hak[x][5] += hak[x][y];
					tot[y-1] += hak[x][y];
					tot[4] += hak[x][y];
				}
			}
		}
		for (int x = 0; x < hak.length; x++) {
			hak[x][6] = 1;
			for (int y = 0; y < hak[x].length-2; y++) {
				if (hak[x][5] < hak[y][5])
					hak[x][6]++;
			}
		}
		/*
		//입력된 자료 출력
		System.out.println("번호\t국어\t영어\t수학\t전산");
		for (int x = 0; x < hak.length; x++) {
			for (int y = 0; y < hak[x].length-2; y++) {
				System.out.print(hak[x][y] + "\t");
			}
			System.out.println();
		}
		*/
		//총점, 석차 포함 출력
		System.out.println("번호\t국어\t영어\t수학\t전산\t총점\t평균\t석차");
		for (int x = 0; x < hak.length; x++) {
			for (int y = 0; y < hak[x].length; y++) {
				if (y != 6)
					System.out.print(hak[x][y] + "\t");
				else {
					System.out.printf("%.2f\t", hak[x][5]/4.);
					System.out.print(hak[x][6]);
				}
			}
			System.out.println();
		}
		//과목별 총점 출력
		System.out.print("합계");
		for (int i = 0; i < tot.length; i++) {
			System.out.print("\t" + tot[i]);
		}
		
		
	}

}


