/*	키보드로 2개의 정수를 입력 받아서 다음과 같이 출력
 * [입력 예시]
 * 입력 : 80 90
 * 큰값 : 90, 작은값 : 80
 * 
 * 입력 : 55 34
 * 큰값 : 55, 작은값 : 34
 * 
 * 입력 : 70 70
 * 두 값은 동일함
 */
public class Exam_08 {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		
		int max = 0;
		int min = 0;
		if (a > b) {
			max = a;
			min = b;
		}
		else if (b > a) {
			max = b;
			min = a;
		}
		else {
			System.out.println("두 값은 동일함");
		}
		System.out.println("큰값 : " + max + ", 작은값 : " + min);
	}

}
