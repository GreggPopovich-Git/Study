import java.util.Arrays;
import java.util.Random;

public class Exam_16 {
	public static void main(String[] args) {
		Random r1 = new Random(); // random 값 발생 클래스 : 정수형 뿐만 아니라 다른것도 됨.
		// r.nextInt(45)+1 // 1~45 까지 난수발생
		int lotto[] = new int[6];
		for (int x = 0; x < lotto.length; x++) {
			lotto[x] = r1.nextInt(45) + 1;
			for (int y = 0; y < x; y++) {
				if (lotto[x] == lotto[y]) {
					x--;
					break;
				}
			}
		}
		System.out.println("Lotto Number : " + Arrays.toString(lotto));	
		
	}

}