package listexam;

import java.util.Scanner;
import java.util.Vector;

public class Exam_09 {

	public static void main(String[] args) {
		Vector<Users> vec = new Vector<Users>();
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.print("회원 등록 : ");
			String[] str = scn.nextLine().split(",");
			if (str[0].equalsIgnoreCase("end"))
				break;
			Users user = new Users(str[0], str[1], Integer.parseInt(str[2]));
			// id 중복검사
			boolean bool = vec.contains(user);
			if (bool) {
				System.out.println("중복된 아이디가 있습니다.");
			}
			else {
				vec.add(user);
			}
		
		}
		
		// 출력
		System.out.println("아이디\t이름\t나이");
		for(int x = 0; x < vec.size(); x++) {
			System.out.println(vec.get(x));
		}
		scn.close();
		
	}

}
