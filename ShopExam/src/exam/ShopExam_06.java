package exam;

import java.util.ArrayList;
import java.util.List;

import dao.ShopDAO;
import vo.ShopVO;

// 회원 매출 정보 출력
// 회원번호	판매번호	단가	수량	가격	상품코드	판매일자
public class ShopExam_06 {

	public static void main(String[] args) {
		List<ShopVO> moList = new ArrayList<ShopVO>();
		ShopDAO dao = ShopDAO.getInstance();
		moList = dao.moneyPrint();
		
		System.out.println("회원번호\t판매번호\t\t단가\t수량\t가격\t상품코드\t판매일자");
		for(int x = 0; x < moList.size(); x++) {
			System.out.print(moList.get(x).getCustno() + "\t");
			System.out.print(moList.get(x).getSaleno() + "\t");
			System.out.print(moList.get(x).getPcost() + "\t");
			System.out.print(moList.get(x).getAmount() + "\t");
			System.out.print(moList.get(x).getPrice() + "\t");
			System.out.print(moList.get(x).getPcode() + "\t");
			System.out.print(moList.get(x).getSdate() + "\n");
		}
	}
}