package warehouse.exam;

import java.util.Scanner;

import warehouse.dao.DAO;
import warehouse.vo.VO;

public class Exam_03 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		VO vo = new VO();
		Scanner scn = new Scanner(System.in);
		System.out.println("입출고등록화면");
		System.out.print("입출고번호 : ");
		int temp = dao.getList();
		System.out.println(temp);
		vo.setT_no(Integer.toString(temp));
		System.out.print("제품코드 : ");
		vo.setP_code(scn.next());
		System.out.print("입출고구분 : ");
		vo.setT_type(scn.next());
		System.out.print("수량 : ");
		vo.setT_cnt(scn.nextInt());
		System.out.print("거래일자 : ");
		vo.setT_date(scn.next());
		System.out.print("거래처 : ");
		vo.setC_code(scn.next());
		
		int row = dao.exam_03(vo);
		if(row == 1)
			System.out.println("등록되었습니다.");
		else
			System.out.println("등록에 실패 했습니다.");
		
		scn.close();
	}

}
