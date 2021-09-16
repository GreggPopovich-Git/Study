package com.jslhrd.exam;

import java.util.List;
import java.util.Scanner;

import com.jslhrd.dao.EmpDAO;
import com.jslhrd.vo.EmpVO;

public class EmpTest {

	public static void main(String[] args) {
		EmpDAO dao = EmpDAO.getInstance();
		EmpView view = new EmpView();
		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("사원 관리 프로그램");
			System.out.println("[1] 사원 전체 List");
			System.out.println("[2] 사원 등록");
			System.out.println("[3] 사원 검색");
			System.out.println("[4] 사원 퇴사 처리(삭제)");
			System.out.println("[5] 사원 정보 수정");
			System.out.println("[0] 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			
			int menu = scn.nextInt();
			switch (menu) {
			case 1:
				List<EmpVO> list = dao.empList();
				view.empList(list);
				break;
			case 2:
				EmpVO vo = view.empInsert();
				int row = dao.empInsert(vo);
				if(row == 1)
					System.out.println("등록되었습니다.");
				else
					System.out.println("등록실패되었습니다.");
				break;
			case 3:
				int eno = view.sabunSearch();
				EmpVO emp = dao.empSearch(eno);
				view.sawonPrint(emp);
				break;
			case 4:
				int eno1 = view.sabunDelete();
				int rowww = dao.empDelete(eno1);
				if(rowww == 1)
					System.out.println("삭제되었습니다.");
				else
					System.out.println("삭제가 실패했습니다.");
				break;
			case 5:
				EmpVO empup = view.updatedata();
				int roww = dao.empUpdate(empup);
				if(roww == 1)
					System.out.println("수정되었습니다.");
				else
					System.out.println("수정 실패했습니다.");
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				scn.close();
				System.exit(0);
			default:
				System.out.println("입력오류입니다.");
				break;
			}// switch() end
		}// while() end
	}// main() end
}