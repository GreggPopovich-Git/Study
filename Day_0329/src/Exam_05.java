import java.util.Scanner;

/* 키보드로 돈(money)와 카드(card)유무 입력 받아서 다음 조건에 맞는 프로그램 작성
 * [입력형식]
 * 현금입력 : 2000
 * 카드유무 : 1
 * 
 * 현금입력 : 3000
 * 카드유무 :        <- 카드가 없는 경우
 * 
 *  처리조건 : 
 *  1. 돈이 3000원 이상 있거나 카드가 있으면 "택시를 타고 가라"
 *     아니면 "걸어서 가라"
 */
public class Exam_05 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("현금입력 : ");
		String money = scn.nextLine();
		System.out.print("카드유무 : ");
		String card = scn.nextLine();
		
		int a = Integer.parseInt(money);
		
		if (a >= 3000 || card.equals("1")) {
			System.out.println("택시 타고 가라");
		}
		else {
			System.out.println("걸어서 가라");
		}
		scn.close();
	}

}
