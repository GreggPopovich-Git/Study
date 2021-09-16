import java.util.Random;

public class Exam_17 {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] number = new int[100];
		int[] counter = new int[10];
		
		for (int i = 0; i < number.length; i++) {
			//System.out.print(number[i] = (int)(Math.random() * 10));
			//0 <= x < 10 범위의 정수 x를 반환 한다.
			System.out.print(number[i] = rand.nextInt(10));
		}
		System.out.println();
		
		for (int i = 0; i < number.length; i++)
			counter[number[i]]++; // 각 값의 개수를 구함.
		for (int i = 0; i < counter.length; i++)
			System.out.println(i + "의 개수 : " + printGraph('#', counter[i]) + " " + counter[i]);
		
	}
	
	public static String printGraph(char ch, int value) { // 난수의 개수에 따라서 문자를 출력해주는 메소드
		char[] bar = new char[value];
		
		for (int i = 0; i < bar.length; i++)
			bar[i] = ch;
		
		return new String(bar); // char[] 배열을 String으로 변환해서 반환함.
	}

}