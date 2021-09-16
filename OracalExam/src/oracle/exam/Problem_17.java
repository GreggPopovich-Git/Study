package oracle.exam;

import java.util.List;

import oracle.dao.DAO;
import oracle.vo.VO;

public class Problem_17 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		List<VO> list = dao.getList_17();
		System.out.println("HIREDATE\tTO_CHAR(HIREDATE,'YY/MON/DDDY)");

		for (int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getHiredate() + "\t");
			System.out.print(list.get(x).getJob() + "\n");
		}
	}
}