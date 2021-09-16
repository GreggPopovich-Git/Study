// 정수 상수(10진수(0~9), 8진수(0시작), 16진수(0x시작), 2진수(0b))
// 실수 상수(고정소수점{Float 7자리 4바이트}, 부동소수점{Double 15자리 8바이트})
public class Exam_04 {
	public static void main(String[] args) {
		int dec = 10;	//10진수
		int oct = 010;	//8진수
		int hex = 0x10;	//16진수
		int bin = 0b10;	//2진수
		
		System.out.println("10진수 : " + dec);
		System.out.println("8진수 : " + oct);
		System.out.println("16진수 : " + hex);
		System.out.println("2진수 : " + bin);
		

	}

}
