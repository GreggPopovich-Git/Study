// contains 문자열이 포함되어 있는지 검사 -> 결과 값은 true or false
public class Exam_06 {

	public static void main(String[] args) {
		String str = "Hello 자바 World 자바 프로그래밍";
		boolean bool = str.contains("자바"); // "자바"가 포함되어 있으면 true, 아니면 false
		System.out.println(bool);
	}

}