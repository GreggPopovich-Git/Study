package oracle.exam;

import java.util.List;

import oracle.dao.DAO;
import oracle.vo.VO;

public class Problem_06 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		List<VO> list = dao.getList_06();
		System.out.println("이름\t업무명\t\t고용날짜");
		
		for(int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getEname() + "\t");
			System.out.print(list.get(x).getJob() + "\t");
			if (list.get(x).getJob().length() < 8)
				System.out.print("\t");
			System.out.print(list.get(x).getHiredate() + "\n");
		}
		
	}

}
