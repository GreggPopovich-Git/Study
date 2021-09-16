// 9-16 예제
public class Exam_09 {

	public static void main(String[] args) {
		int iVal = 100;
		String strVal = String.valueOf(iVal); // int를 String 으로 변환
		
		double dVal = 200.0;
		String strVal2 = dVal + ""; // String 으로 변환하는 또 다른 방법
		
		double sum = Integer.parseInt("+" + strVal) + Double.parseDouble(strVal2); // 래퍼클래스를 이용해서 변환.
		
		double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2); // 각 클래스의 valueOf로도 변환가능.
		
		System.out.println(String.join("", strVal, "+", strVal2, "=") + sum);
		System.out.println(strVal + "+" + strVal2 + "=" + sum2);
		
	}

}