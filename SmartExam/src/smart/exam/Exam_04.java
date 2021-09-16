package smart.exam;

import java.util.List;

import smart.dao.SmartDao;
import smart.vo.SmartVO;

public class Exam_04 {

	public static void main(String[] args) {
		SmartDao dao = SmartDao.getInstance();
		List<SmartVO> list = dao.exam_04();
		System.out.println("작업지시번호\t제품코드\t제품명\t\t준비\t인쇄\t코팅\t합지\t접합\t포장\t최종공정일자\t최종공정시간");
		for (int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getW_workno() + "\t");
			System.out.print(list.get(x).getP_code() + "\t");
			System.out.print(list.get(x).getP_name() + "\t");
			System.out.print(list.get(x).getP_p1() + "\t");
			System.out.print(list.get(x).getP_p2() + "\t");
			System.out.print(list.get(x).getP_p3() + "\t");
			System.out.print(list.get(x).getP_p4() + "\t");
			System.out.print(list.get(x).getP_p5() + "\t");
			System.out.print(list.get(x).getP_p6() + "\t");
			System.out.print(list.get(x).getW_lastdate() + "\t");
			System.out.print(list.get(x).getW_lasttime() + "\n");
		}
	}
}
