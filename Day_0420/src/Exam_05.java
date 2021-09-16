// 문자열 처리 - String 클래스를 이용
class StringTest {
	
}
class FF {
	
}
public class Exam_05 {
	public static void main(String[] args) {
		String str = "12345ABCDEF"; // 문자열 저장
		// 문자열 길이
		System.out.println("문자열길이 : " + str.length()); // 문자열 길이를 정수형으로 출력
		// 문자열 분리 substring(시작위치, 전까지)
		String s = str.substring(5); // 문자열 index 0번쨰 부터 5번째 까지 꺼내옴
		System.out.println(s);
		System.out.println(str.substring(2,7)); // index 2번째 부터 7번째 전까지(6번째 까지) 꺼내옴
		for (int x = 0; x < str.length(); x++) {
			System.out.println(str.charAt(x)); // 문자열에서 index x번째 한글자만 꺼내옴
			System.out.println(str.substring(x,x+1));
		}
		
		String ss = "1101,김학생,90,77,99";
		String[] sss = ss.split(","); // ","를 기준으로 문자열을 분리해서 스트링 배열에 하나씩 넣어줌.
		for (String hak : sss) // 확장 for문 sss스트링 배열을 하나씩 꺼내서 hak에 넣어줌.
			System.out.println(hak);
		
	}
}