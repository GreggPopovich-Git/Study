/* 1 ~ 10 (1+2+3+4+...+10) 합계 구하여 출력
 * [결과출력예시]
 * 1~10 합계 : 55
 */
public class Exam_02 {
	public static void main(String[] args) {
		int s = 0;
		int score = Integer.parseInt(args[0]);
		for (int x=1; x<=score; x++) {
			System.out.println(x);
			s+=x;
		}
		System.out.println("1~10 합계 : " + s);
	}

}
