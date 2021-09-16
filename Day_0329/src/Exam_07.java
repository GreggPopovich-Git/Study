import java.util.Scanner;

/*	현재 은행잔고(account=10000) 있다는 전제하에 카드가 있으면 인출한다.
 * (단, 잔액 부족 시 "잔고 부족" 에러 메시지와 현재 잔액을 출력하고
 * 그렇지 않으면 "출금 완료" 출력 후 잔액 출력)
 * [입력 형식]
 * 체크카드 유무(y/n) : y
 * 현금인출 : 5000
 * 출금완료(잔액 : 5000)
 * 
 * 체크카드 유무(y/n) : y
 * 현금인출 : 15000
 * 잔고부족(잔액 : 10000)
 * 
 * 카드 유무 :    -> 카드가 없는 경우
 * 인출을 종료합니다.
 */
public class Exam_07 {
	public static void main(String[] args) {
		int account = 10000;
		Scanner scn = new Scanner(System.in);
		System.out.print("체크카드 유무(Y/N) : ");
		String check = scn.nextLine();
		
		if (check.equalsIgnoreCase("y")) {
			System.out.print("현금인출 : ");
			int money = scn.nextInt();
			if (account < money) {
				System.out.println("잔고부족 (잔액 : " + account + " )");
			}
			else {
				account -= money;
				System.out.println("출금완료 (잔액 : " + account + " )");
			}
		}
		else {
			System.out.println("인출을 종료합니다.");
		}
		scn.close();
	}

}
