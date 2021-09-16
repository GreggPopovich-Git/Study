package mapexam;

import java.util.HashMap;
import java.util.Map;
// map 컬렉션에 아이디, 비번이 저장되어 있을 경우 로그인 체크
public class Exam_04 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user01", "1234");
		map.put("abcd", "4321");
		map.put("java", "1111");
		map.put("spring", "2222");
		
		// 키보드로 id, pass 입력받아서 로그인하기
		String id = "user02";
		String pass = "1234";
		if(map.containsKey(id)) {
			if(map.get(id).equals(pass))
				System.out.println("로그인 성공");
			else
				System.out.println("비밀번호가 틀립니다.");
		}
		else
			System.out.println("아이디가 존재하지 않습니다.");
		
	}

}