package smart.exam;

import java.util.List;

import smart.dao.SmartDao;
import smart.vo.SmartVO;

public class Exam_02 {

	public static void main(String[] args) {
		SmartDao dao = SmartDao.getInstance();
		List<SmartVO> list = dao.exma_02();
		System.out.println("작업지시번호\t제품코드\t제품명\t\t제품규격\t\t제품구분\t수량\t작업지시일");
		for (int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getW_workno() + "\t");
			System.out.print(list.get(x).getP_code() + "\t");
			System.out.print(list.get(x).getP_name() + "\t");
			System.out.print(list.get(x).getP_size() + "\t");
			System.out.print(list.get(x).getP_type() + "\t");
			System.out.print(list.get(x).getW_quentity() + "\t");
			System.out.print(list.get(x).getW_workdate() + "\n");
		}

	}

}
