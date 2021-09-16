package warehouse.exam;

import java.util.List;

import warehouse.dao.DAO;
import warehouse.vo.VO;

public class Exam_06 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		List<VO> list = dao.exam_06();
		System.out.println("제품코드\t제품명\t\t출고수량\t출고매출이익");
		for (int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getP_code() + "\t");
			System.out.print(list.get(x).getP_name() + "\t");
			System.out.print(list.get(x).getT_cnt() + "\t");
			System.out.print(list.get(x).getTel1() + "\n");
		}
		
	}

}
