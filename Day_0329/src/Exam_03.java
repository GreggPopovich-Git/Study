import java.util.Scanner;

// 키보드로 색상을 입력 받아서 'blue'이면 'Pass'
// 'red' 이면 'Stop'
public class Exam_03 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("색상입력 : ");
		String color = scn.next();
		
		if (color.equals("blue")) { //equals 는 대,소문자 구분 / equalsIgnore 는 대,소문자 구분 안함
			System.out.println("Pass");
		}
		else {
			System.out.println("Stop");
		}
		scn.close();
	}

}
