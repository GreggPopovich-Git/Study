package exam;

import java.util.List;

import dao.DAO;
import vo.VO;

public class Exam_04 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		List<VO> list = dao.exam_4();
		System.out.println("\t\t\t측정이력조회");
		System.out.println("관측일자\t\t측정시기\t대기오염코드\t관측지점번호\t관측지점명\t권역지역명\t측정값");
		for(int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getTest_date() + "\t");
			System.out.print(list.get(x).getTest_ampm() + "\t");
			System.out.print(list.get(x).getPollution() + "\t\t");
			System.out.print(list.get(x).getCity_code() + "\t\t");
			System.out.print(list.get(x).getCity_name() + "\t");
			System.out.print(list.get(x).getArea_name() + "\t");
			System.out.print(list.get(x).getTest_value() + "\n");
		}
		
	}

}
