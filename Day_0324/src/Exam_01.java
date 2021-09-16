// 상수(Literal) ASCII code = 7bit -> 128개의 서로 다른 문자
// ASCII code -> 숫자(0~9 = 48~57), 영어 대문자(A~Z = 65~90), 영어 소문자(a~z = 97~123)
public class Exam_01 {
	public static void main(String[] args) {
		char ch = 48;//'0'
		int num = 'A'+1;
		System.out.println("ch = " + ch);
		System.out.println("num = " + (char)num);

	}

}
