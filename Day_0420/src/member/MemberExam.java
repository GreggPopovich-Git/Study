package member;
import java.util.Scanner;
public class MemberExam {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Member all[] = new Member[10];
		int cnt = 0;
		while (true) {
			System.out.print("회원정보 입력 : ");
			String mem[] = scn.nextLine().split(",");
			if (mem[0].equalsIgnoreCase("end"))
				break;
			String name = mem[0];
			int age = Integer.parseInt(mem[1].substring(0,2));
			String phone = mem[2];
			int sex = Integer.parseInt(mem[1].substring(mem[1].length()-1));
			all[cnt] = new Member(name,age,phone,sex);
			cnt++;
		}
		//출력
		System.out.println("이름\t전화\t\t성별\t나이");
		for (int x = 0; x < cnt; x++) {
			all[x].mPrint();
		}
		scn.close();
	}
}