import java.util.Scanner;

/* 화폐단위별 매수 출력
 * 키보드로 금액을 입력 받아서 화폐단위별 매수를 구하여 출력
 * [입력 형식]
 * 금액 176668
 * 50000원 : 3
 * 10000원 : 2
 * 5000원 : 1
 * 1000원 : 1
 * 500원 : 1
 * 100원 : 1
 * 50원 : 1
 * 10원 : 1
 * 5원 : 1
 * 1원 : 3
 */
public class Exam_01 {
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		System.out.print("금액 입력 : ");
		int money = scn.nextInt();
		int cash = 50000;
		int cnt = 0;
		int i = 0;
		while (money != 0) {
			i++;
			if (i%2 != 0) {
				cnt = money/cash;
				money %= cash;
				System.out.println(cash + "원 : " + cnt);
				cash /= 5;
			}
			else {
				cnt = money/cash;
				money %= cash;
				System.out.println(cash + "원 : " + cnt);
				cash /= 2;
			}
		}
		scn.close();
	}
}