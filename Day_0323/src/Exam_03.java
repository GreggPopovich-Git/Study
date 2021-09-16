// 식별자와 예약어
// 식별자 : 1. 클래스 이름, 인터페이스, 변수 이름, 메소드 이름 등 사용자가 바꿀 수 있는 것들
//       2. 사용문자 : 영문자(대,소문자 구분), 숫자, 특수문자 중에 ( _ $ ) 단, 첫자는 무조건 영문자 or 특수문자
//       3. 예약어는 식별자로 사용할 수 없음. ex) class
// 자료형(Data Type) : 기본형 8가지 + 참조형
// 1. 기본형 : 문자형(char), 정수형(byte, short, int, long), 실수형(float, double), 논리형(boolean[true,false])
// 2. 참조형 : 참조형 : 클래스(String,...), 인터페이스(Collection,...), 배열([])
public class Exam_03 {
	public static void main(String[] args) {
		// 변수 선언
		// 자료형 변수이름;
		int kor = 10;
		double ave = 3.14;
		char str = 'A';
		boolean flag = true;
		// 변수 초기화
		kor=0;
		ave=3.14;
		str='A';
		flag=true;
		
		System.out.println("kor = " + kor);
		System.out.println("ave = " + ave);
		System.out.println("str = " + str);
		System.out.println("flag = " + flag);

	}

}
