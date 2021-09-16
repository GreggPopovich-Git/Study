
public class Exam_02 {

	public static void main(String[] args) {
		// 바이트 배열을 이용한 String 객체 생성 Hello Java // 한글도 1바이트
		byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
		String by = new String(bytes); // 아스키 코드값으로 받음.
		System.out.println(by);
		
		String by2 = new String(bytes,6,4); // bytes 의 6번째부터 4개의 자료만 아스키코드로 변형해서 가져옴
		System.out.println(by2);
		// char 배열을 이용한 String 객체 생성
		char[] chars = {'K','o','r','e','a','한','글'};
		String ch = new String(chars);
		System.out.println(ch);
		
	}

}