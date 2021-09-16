// 난수 발생 Math.random()
public class Exam_13 {

	public static void main(String[] args) {
		// start(1~10)
		int num1 = (int)(Math.random()*10) + 1; // 1~10 사이의 난수
		System.out.println(num1);
		// 1~6
		int num2 = (int)(Math.random()*6) + 1;
		System.out.println(num2);
		// 1~45
		int num3 = (int)(Math.random()*45) + 1;
		System.out.println(num3);
		
		for (int x = 1; x < 11; x++) {
			int a = (int)(Math.random()*6) + 1;
			System.out.println(x + " : " + a);
		}
		
	}

}