package exam;

import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import vo.VO;

public class Exam_04 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		List<VO> oList = new ArrayList<VO>();
		oList = dao.orderList();
		System.out.println("예방접종이력번호\t고객번호\t고객명\t백신코드\t백신주사명\t\t접종일자");
		for (int x = 0; x < oList.size(); x++) {
			System.out.print(oList.get(x).getP_city() + "\t");
			System.out.print(oList.get(x).getP_no() + "\t");
			System.out.print(oList.get(x).getP_name() + "\t");
			System.out.print(oList.get(x).getI_code() + "\t");
			System.out.print(oList.get(x).getI_name() + "\t");
			if (oList.get(x).getI_name().length() < 6)
				System.out.print("\t");
			System.out.print(oList.get(x).getP_date() + "\n");
		}

	}

}
