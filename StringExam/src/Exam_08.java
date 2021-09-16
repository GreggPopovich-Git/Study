// String.fomat
public class Exam_08 {

	public static void main(String[] args) {
		int a = 100;
		String b = "aaaaa";
		System.out.println(String.format("%10d", 10)); // %d 정수형, %10d 는 10자리 (오른쪽 정렬)
		System.out.println(String.format("%10d", a));
		System.out.println(String.format("%10d", 1000));
		System.out.println(String.format("%10d", 10000));
		System.out.println(String.format("%7.2f", 3.14567)); // %f는 실수형, 총 7자리 중에 2자리는 소숫점 아래
		System.out.println(String.format("%10s", "aaa")); // %s 문자열
		System.out.println(String.format("%10s", b));
		
		String s = a + ""; // 문자열을 더하면 문자로 변환됨.
		String s1 = String.valueOf(a); // String형으로 변환, toString과 다른점은 값이 null인 경우 valueOf는 "null"이 입력됨.
		int c = Integer.parseInt(s1); // Integer를 이용해 정수형으로 변환
		String boo = "true";
		boolean bool = Boolean.parseBoolean(boo); // 래퍼클래스 : 기본 자료형을 클래스화 시켜놓은 클래스(다양한 메소드를 사용할 수 있음)
		boolean bo = Boolean.parseBoolean(s1); // Wrapper Class
		System.out.println(bool); // "true"를 boolean 으로 변환한 값. true가 출력됨.
		System.out.println(bo); // String "100"을 boolean으로 변환한 값. false가 출력됨.
	}

}