// concat 문자열 결합
public class Exam_05 {

	public static void main(String[] args) {
		String str = "";
		for (int x = 0; x < 10; x++)
			str += x;
		System.out.println(str);
		String str1 = "";
		for (int x = 0; x < 10; x++)
			str1 = str1.concat("" + x); // x를 문자로 변환하기 위해서 ""를 더해주고 concat을 이용해서 결합함.
		System.out.println(str1);
	}

}