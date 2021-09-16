package exam;

import java.time.LocalDate;
import java.util.Scanner;
import dao.ShopDAO;
import vo.ShopVO;

public class ShopExam_01 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		ShopDAO dao = ShopDAO.getInstance();
		int custno = dao.custMaxNo();
		ShopVO vo = new ShopVO();
		System.out.println("회원 정보 등록 화면");
		System.out.print("회원번호 : ");
		System.out.println(custno + 1);
		vo.setCustno(custno + 1);
		System.out.print("회원성명 : ");
		String name = scn.next();
		vo.setCustname(name);
		System.out.print("회원전화 : ");
		vo.setPhone(scn.next());
		System.out.print("성별(M/F) : ");
		vo.setGender(scn.next());
		System.out.print("가입일자 : ");
		System.out.println(LocalDate.now());
		String[] d = LocalDate.now().toString().split("-");
		String dd = d[0] + d[1] + d[2];
		vo.setJoindate(dd);
		System.out.print("고객등급 : ");
		vo.setGrade(scn.next());
		System.out.print("도시코드 : ");
		vo.setCity(scn.next());
		int row = dao.shopInsert(vo);
		if (row == 1)
			System.out.println("등록되었습니다.");
		else
			System.out.println("등록에 실패하였습니다.");
		scn.close();
	}
}