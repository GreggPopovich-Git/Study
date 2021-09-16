import java.util.StringJoiner;

public class Exam_07 {

	public static void main(String[] args) {
		String animals = "dog,cat,bear";
	      String[] arr = animals.split(","); // String 클래스의 split은 구분자를 하나밖에 쓸 수 없음.
	      
	      System.out.println(String.join("-", arr)); // 각각의 index 값 사이에 join 메소드를 이용해서 넣음.
	      
	      StringJoiner sj = new StringJoiner("/","[","]"); // StringJoiner 클래스는 맨앞, 맨뒤, 사이에 원하는 걸 넣을 수 있음.
	      for(String s : arr) // 확장 for문
	         sj.add(s); // StringJoiner 클래스는 add 메소드를 통해 내용을 추가함.
	      System.out.println(sj.toString()); // sj를 String 으로 바꿔줌.
	      System.out.println(sj); // 안바꿔도 똑같이 출력됨.

	}

}