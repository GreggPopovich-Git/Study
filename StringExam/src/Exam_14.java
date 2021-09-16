import java.util.Arrays;
// 로또 번호 생성
public class Exam_14 {

	public static void main(String[] args) {
		int lotto[] = new int[6];
		for (int x = 0; x < lotto.length; x++) {
			lotto[x] = (int)(Math.random() * 45) + 1;
			for (int y = 0; y < x; y++) {
				if (lotto[x] == lotto[y]) { // 중복된 값이 발생하면 다시
					x--;
					break;
				}
			}
		}
		System.out.println("Lotto Number : " + Arrays.toString(lotto));
	}
}