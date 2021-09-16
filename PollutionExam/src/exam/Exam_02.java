package exam;

import java.util.List;

import dao.DAO;
import vo.VO;

public class Exam_02 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		List<VO> list = dao.exam_2();
		System.out.println("\t\t\t관측 지점 조회");
		System.out.println("관측지점번호\t관측지점명\t권역코드\t권역명칭\t담당전화\t\t담당자\t직급");
		for(int x = 0; x < list.size(); x++) {
			System.out.print("   " + list.get(x).getCity_code() + "\t\t");
			System.out.print(list.get(x).getCity_name() + "\t");
			System.out.print(list.get(x).getArea_code() + "\t");
			System.out.print(list.get(x).getArea_name() + "\t");
			System.out.print(list.get(x).getCity_tel1() + "\t");
			System.out.print(list.get(x).getCity_admin() + "\t");
			System.out.print(list.get(x).getCity_level() + "\n");
		}

	}

}
