// 형변환
public class Exam_04 {
	public static void main(String[] args) {
		// 자동 형변환
		byte by = 100;
		int score = by;
		System.out.println("by = " + by + "   score = " + score);
		// 강제 형변환
		byte by2 = (byte)score;
		System.out.println("by2 = " + by2);
		// 강제 형변환 오류
		int score2 = 255;
		byte by3 = (byte)score2;
		System.out.println("by3 = " + by3 + "   score = " + score2);
		
	}

}
