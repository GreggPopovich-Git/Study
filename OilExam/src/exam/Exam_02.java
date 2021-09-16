package exam;

import java.text.DecimalFormat;
import java.util.List;

import dao.DAO;
import vo.VO;

public class Exam_02 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		List<VO> list = dao.exam_2();
		System.out.println("주유일자\t\t유종\t건수\t금액");
		DecimalFormat df = new DecimalFormat("￦#,###");
		for(int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getOildate() + "\t");
			System.out.print(list.get(x).getOilname() + "\t");
			System.out.print(list.get(x).getAmount() + "\t");
			System.out.print(df.format(list.get(x).getOilcost()) + "\n");
		}
		
	}

}