package exam;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import dao.ShopDAO;
import vo.ShopVO;

public class ShopExam_02 {

	public static void main(String[] args) {
		ShopDAO dao = ShopDAO.getInstance();
		Scanner scn = new Scanner(System.in);
		ShopVO vo = new ShopVO();
		System.out.println("회원 매출 정보 등록 화면");
		System.out.print("회원 번호 : ");
		vo.setCustno(scn.nextInt());
		System.out.print("판매 번호 : ");
		vo.setSaleno(scn.nextInt());
		System.out.print("단가 : ");
		vo.setPcost(scn.nextInt());
		System.out.print("수량 : ");
		vo.setAmount(scn.nextInt());
		System.out.print("가격 : ");
		vo.setPrice(vo.getPcost() * vo.getAmount());
		System.out.println(vo.getPcost() * vo.getAmount());
		System.out.print("상품 코드 : ");
		vo.setPcode(scn.next());
		System.out.print("판매 일자 : ");
		System.out.println(LocalDate.now().toString());
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		vo.setSdate(df.format(now));
		
		int row = dao.moneyInsert(vo);
		if(row == 1) 
			System.out.println("등록완료");
		else
			System.out.println("등록실패");
		scn.close();
	}

}
