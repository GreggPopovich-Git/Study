package smart.exam;

import java.text.DecimalFormat;
import java.util.List;

import smart.dao.SmartDao;
import smart.vo.SmartVO;

public class Exam_01 {

	public static void main(String[] args) {
		SmartDao dao = SmartDao.getInstance();
		List<SmartVO> list = dao.exma_01();
		System.out.println("제품코드\t제품명\t\t제품규격\t\t제품구분\t제품단가");
		DecimalFormat df = new DecimalFormat("￦#,###");
		for (int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getP_code() + "\t");
			System.out.print(list.get(x).getP_name() + "\t");
			System.out.print(list.get(x).getP_size() + "\t");
			System.out.print(list.get(x).getP_type() + "\t");
			System.out.print(df.format(list.get(x).getP_price()) + "\n");
		}

	}

}
