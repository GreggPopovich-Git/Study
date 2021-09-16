// 정렬법  - 오름차순(ASC)
// 		- 내림차순(DESC)
// 1. 선택 정렬법 (Selection Sort) - 기준점 (배열의 0번째 자료부터 나머지를 비교 하면서 교환)
// 2. 거품 정렬법 (Bubble Sort)
// 3. 삽입 정렬법 (Insertion Sort)
// 정렬 - 검색 - 병합
public class Exam_03 {
	public static void main(String[] args) {
		int score[] = {70,90,80,77,85,50,60};
		int length = score.length;
		System.out.print("Source : ");
		for (int x = 0; x < length; x++) {
			System.out.print(score[x] + "\t");
		}
		System.out.println();
		// 오름차순으로 sort
		for (int x = 0; x < score.length-1; x++) { //기준
			for (int y = x + 1; y < score.length; y++) { //비교대상
				if (score[x] > score[y]) {
					int temp = score[x];
					score[x] = score[y];
					score[y] = temp;
				}
			}
		}
		System.out.print("Sort   : ");
		for (int x = 0; x < length; x++) {
			System.out.print(score[x] + "\t");
		}
	}

}
