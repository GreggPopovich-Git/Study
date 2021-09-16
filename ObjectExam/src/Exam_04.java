// hashCode() - String의 문자열이 같으면 hashCode()의 값도 같아짐.(해쉬코드가 같도록 오버라이딩 되어있음.)
public class Exam_04 {

	public static void main(String[] args) {
		String str1 = "AAA";
		String str2 = new String("AAA");
		System.out.println("str1 = " + str1.hashCode());
		System.out.println("str2 = " + str2.hashCode());
	}

}