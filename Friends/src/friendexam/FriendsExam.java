package friendexam;

import java.util.Scanner;

public class FriendsExam {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		FriendsMethod fm = new FriendsMethod();
		while (true) {
			System.out.print("[1]친구추가 [2]전체보기 [3]친구찾기 [4]수정,삭제 [5]종료 : ");
			int temp = scn.nextInt();
			if (temp == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (temp == 1) {
				fm.insert();
			} else if (temp == 2) {
				fm.print();
			} else if (temp == 3) {
				fm.search();
			} else if (temp == 4) {
				fm.modify();
			} else
				System.out.println("잘못 입력 하셨습니다.");
		}
		scn.close();
	}
}
