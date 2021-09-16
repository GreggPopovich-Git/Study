package listexam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 회원가입시 id 중복 검사
 * 입력형식 : id,name,age
 * 
 */
public class Exam_06 {

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
			boolean bool = true;
			for (int x = 0; x < uList.size(); x++) {
				if (user.equals(uList.get(x)))
					bool = false;
			}
			if (bool == true)
				uList.add(user);
			else
				System.out.println("중복된 아이디가 있습니다.");
		}
		// 출력
		System.out.println("아이디\t이름\t나이");
		for(int x = 0; x < uList.size(); x++) {
			System.out.print(uList.get(x).getId() + "\t");
			System.out.print(uList.get(x).getName() + "\t");
			System.out.print(uList.get(x).getAge() + "\n");
		}
		scn.close();
	}

}