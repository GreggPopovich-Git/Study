package listexam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam_07 {

	public static void main(String[] args) {
		List<Users> uList = new ArrayList<Users>();
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.print("회원 등록 : ");
			String[] str = scn.nextLine().split(",");
			if (str[0].equalsIgnoreCase("end"))
				break;
			Users user = new Users(str[0], str[1], Integer.parseInt(str[2]));
			// id 중복검사
			boolean bool = uList.contains(user);
			if (bool) {
				System.out.println("중복된 아이디가 있습니다.");
			}
			else {
				uList.add(user);
			}
		
		}
		
		// 출력
		System.out.println("아이디\t이름\t나이");
		for(int x = 0; x < uList.size(); x++) {
			System.out.println(uList.get(x));
		}
		scn.close();

	}

}