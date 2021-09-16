package warehouse.exam;

import java.util.List;

import warehouse.dao.DAO;
import warehouse.vo.VO;

public class Exam_04 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		List<VO> list = dao.exam_04();
		System.out.println("입출고번호\t\t제품코드\t제품명\t\t입출고구분\t수량\t거래처\t거래일자");
		for (int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getT_no() + "\t");
			System.out.print(list.get(x).getP_code() + "\t");
			System.out.print(list.get(x).getP_name() + "\t");
			System.out.print(list.get(x).getT_type() + "\t");
			System.out.print(list.get(x).getT_cnt() + "\t");
			System.out.print(list.get(x).getC_name() + "\t");
			System.out.print(list.get(x).getT_date() + "\n");
			
		}
		
	}

}
