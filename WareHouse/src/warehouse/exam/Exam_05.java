package warehouse.exam;

import java.util.Scanner;

import warehouse.dao.DAO;

public class Exam_05 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		DAO dao = DAO.getInstance();
		System.out.println("입출고 삭제");
		System.out.print("입출고 번호 : ");
		String t_no = scn.next();
		int row = dao.exam_05(t_no);
		if(row == 1)
			System.out.println("삭제되었습니다.");
		else
			System.out.println("삭제가 실패했습니다.");
		scn.close();
	}

}
