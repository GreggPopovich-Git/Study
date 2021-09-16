package exam;

import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import vo.VO;

public class Exam_02 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		List<VO> cList = new ArrayList<VO>();
		cList = dao.custList();
		System.out.println("고객번호\t고객명\t고객생년월일\t\t성별\t전화번호\t\t지역");
		for (int x = 0; x < cList.size(); x++) {
			System.out.print(cList.get(x).getP_no() + "\t");
			System.out.print(cList.get(x).getP_name() + "\t");
			String year = cList.get(x).getP_birth().substring(0, 4);
			String month = cList.get(x).getP_birth().substring(4, 6);
			String day = cList.get(x).getP_birth().substring(6);
			System.out.print(year + "년" + month + "월" + day + "일" + " ");
			System.out.print("(" + (2021 - Integer.parseInt(year)) + ")\t");
			System.out.print(cList.get(x).getP_gender() + "\t");
			System.out.print(cList.get(x).getP_tel1() + "\t");
			System.out.print(cList.get(x).getP_city() + "\n");
		}
	}
}