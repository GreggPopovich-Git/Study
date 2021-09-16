import java.util.Scanner;
import java.util.regex.Pattern;

// 키보드로 입력된 데이터 중 숫자
public class Exam_18 {

	public static void main(String[] args) {
		// 정규표현식 - 자료의 오류 판별을 위해 사용.
		Scanner scn = new Scanner(System.in);
		System.out.print("점수 입력(구분,) : ");
		String[] str = scn.nextLine().split(",");
		for (int x = 0; x < str.length; x++) {
			boolean bool = Pattern.matches("\\d+", str[x]); // Pattern 을 이용한 자료 체크 boolean 값으로 나옴.
			if (bool)
				System.out.println(str[x] + " 는 숫자");
			else
				System.out.println("오류");
		}
		scn.close();
		
	}

}