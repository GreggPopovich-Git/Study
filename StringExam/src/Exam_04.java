// 자바의 정석 p469 사전순서(알파벳순서)로 A로 B를 비교해서 B가 A의 앞쪽에 존재하면 음수, 뒤쪽에 존재하면 양수, A와 B가 같으면 0.
// 

public class Exam_04 {
	public static void main(String[] args) {
		String str1 = "Korea";
		String str2 = "Seoul";
		int c = str1.compareTo(str2); // 알파벳 순서로 str1 보다 str2 가 앞에 있으면 음수, 뒤쪽에 있으면 양수, 같으면 0
		if (c == 0)
			System.out.println("같다");
		else if (c < 0)
			System.out.println("앞에");
		else
			System.out.println("뒤에");
	}

}