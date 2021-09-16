package exam;

import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import vo.VO;

public class Exam_05 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		List<VO> cList = new ArrayList<VO>();
		cList = dao.countList();
		System.out.println("백신코드\t백신주사명\t\t백신별총건수");
		for (int x = 0; x < cList.size(); x++) {
			System.out.print(cList.get(x).getI_code() + "\t");
			System.out.print(cList.get(x).getI_name() + "\t");
			if(cList.get(x).getI_name().length() < 6)
				System.out.print("\t");
			System.out.print(cList.get(x).getP_seno() + "\n");
		}
		
	}

}
