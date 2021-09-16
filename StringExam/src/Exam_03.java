
public class Exam_03 {

	public static void main(String[] args) {
		String str = "Hello 자바 World 자바 프로그래밍";
		// 문자열 길이
		int cnt1 = str.length();
		int cnt2 = "Hello World 자바 프로그래밍".length();
		System.out.println("문자열 길이 : " + cnt1);
		System.out.println("문자열 길이 : " + cnt2);
		// 1문자 추출 charAt(index)
		char ch = str.charAt(6); // W 추출
		System.out.println("6번째 문자 추출 : " + ch);
		// 전체 문자열에서 1문자씩 추출
		for (int x = 0; x < str.length(); x++) {
			char c = str.charAt(x);
			System.out.println(c);
		}
		// 문자찾기(위치) indexOf('')
		int index = str.indexOf("자바"); // 앞에서 부터 검색
		System.out.println(index);
		int index2 = str.lastIndexOf('자'); // 뒤에서 부터 검색
		System.out.println(index2);
	}
}