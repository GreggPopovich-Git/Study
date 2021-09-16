package exam;

import java.util.Scanner;

import dao.DAO;
import vo.VO;

public class Exam_03 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		VO vo = new VO();
		DAO dao = DAO.getInstance();
		while(true) {
			System.out.println("예방접종 등록 화면");
			System.out.print("예방접종이력번호 : ");
			int seno = scn.nextInt();
			if(seno == -99) {
				System.out.println("종료합니다.");
				break;
			}
			vo.setP_seno(seno);
			System.out.print("고객번호 : ");
			vo.setP_no(scn.next());
			System.out.print("백신코드 : ");
			vo.setI_code(scn.next());
			System.out.print("접종일자 : ");
			vo.setP_date(scn.next());
			int row = dao.orderInsert(vo);
			if(row == 1)
				System.out.println("등록되었습니다.");
			else
				System.out.print("등록에 실패 했습니다.");
		}
		scn.close();
	}
}