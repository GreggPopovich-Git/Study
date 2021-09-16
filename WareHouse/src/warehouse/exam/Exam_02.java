package warehouse.exam;

import java.util.List;

import warehouse.dao.DAO;
import warehouse.vo.VO;

public class Exam_02 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		List<VO> list = dao.exam_02();
		System.out.println("제품코드\t제품명\t\t사이즈\t매입단가\t출고단가");
		for (int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getP_code() + "\t");
			System.out.print(list.get(x).getP_name() + "\t");
			System.out.print(list.get(x).getC_name() + "\t");
			System.out.print(list.get(x).getTel1() + "\t");
			System.out.print(list.get(x).getTel2() + "\n");
		}
		
	}

}
