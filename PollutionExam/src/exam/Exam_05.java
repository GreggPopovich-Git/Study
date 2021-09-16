package exam;

import java.util.List;

import dao.DAO;
import vo.VO;

public class Exam_05 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		List<VO> list = dao.exam_5();
		System.out.println("\t\t지역별관측조회");
		System.out.println("관측일자\t\t관측지점명\t일평균수치\t\t상태");
		for(int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getTest_date() + "\t");
			System.out.print(list.get(x).getCity_name() + "\t");
			System.out.print(list.get(x).getTest_value() + "\t\t");
			System.out.println(list.get(x).getPollution());
		}
		
	}

}
