
public class Exam_12 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("01");
		StringBuffer sb2 = sb.append(23);
		sb.append('4').append(56);
		
		StringBuffer sb3 = sb.append(78);
		sb3.append(9.0); // sb3을 만들 때 new 를 쓰지 않아서 sb, sb2에도 영향을 끼침.
		
		System.out.println("sb = " + sb);
		System.out.println("sb2 = " + sb2);
		System.out.println("sb3 = " + sb3);
		
		System.out.println("sb = " + sb.deleteCharAt(10)); // index 10번째 값을 삭제
		System.out.println("sb = " + sb.delete(3, 6)); // index 3번째부터 6번째 전까지 삭제
		System.out.println("sb = " + sb.insert(3, "abc")); // index 3번째에 "abc"를 삽입
		System.out.println("sb = " + sb.replace(6, sb.length(), "END")); // index 6번째 부터 끝까지를 "END"로 치환
		
		System.out.println("cpapcity = " + sb.capacity()); // StringBuffer의 크기
		System.out.println("length = " + sb.length()); // 문자열의 길이
	}

}