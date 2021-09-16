// String 객체는 heap에 생성 되지 않고 JVM에 생성되어서 따로 관리 됨.
// String 객체는 내용이 변할 수 없음.
public class Exam_01 {

	public static void main(String[] args) {
		String str1 = "aaa";
		String str2 = "aaa";
		String str3 = new String("aaa");
		System.out.println(str1.hashCode());
		str1 = str1 + "000";
		System.out.println(str1.hashCode()); // hashCode가 바뀌었다는 얘기는 값을 변경한 것이 아니라 새로운 객체가 새롭게 생성된 것임.
		System.out.println(str2.hashCode()); // hashCode가 같음. (즉, 값이 같으면 새로운 객체를 만들지 않고 공유함)
		str1 = "aaa";
		System.out.println(str3.hashCode()); // new를 쓰면 새로운 객체를 생성함. String 클래스는 서로 달라도 hashCode는 같은 값을 갖게 함.
		
		System.out.println(str1 == str2);
		System.out.println(str2 == str3); // new를 이용했을 때는 서로 주소 값이 다름.
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3)); // 문자열 비교는 내용이 같기 때문에 true
	}
}