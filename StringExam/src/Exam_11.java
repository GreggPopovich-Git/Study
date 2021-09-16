// StringBuffer : 동적인 문자열 처리 - 멀티 스레드 지원 o (속도 저하의 단점)
// StringBuilder : 멀티 스레드 지원 x (단일 스레드)
// JVM에 생성되는 String과 달리 메모리에 생성되기 때문에 공유가 되지 않음
// 문자열 추가 append(무조건 뒤에 추가) insert(원하는 위치에 추가), capacity 크기, delete 삭제, replace, reverse 등등의 메소드가 있음.
public class Exam_11 {
	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer(); // 디폴트 값 16 (가변)
		StringBuffer sb2 = new StringBuffer(20);
		StringBuffer sb3 = new StringBuffer("java programming"); // 기본문자열 + 16
		
		System.out.println(sb1.capacity());
		System.out.println(sb2.capacity());
		System.out.println(sb3.capacity());
		
		System.out.println(sb1); // 아무것도 출력되지 않음.
		System.out.println(sb2); // 아무것도 출력되지 않음.
		System.out.println(sb3);
	}

}