package oracle.exam;

import java.util.List;

import oracle.dao.DAO;
import oracle.vo.VO;

public class Problem_18 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		List<VO> list = dao.getList_18();
		System.out.println("사번\t이름\t관리번호");

		for (int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getEno() + "\t");
			System.out.print(list.get(x).getEname() + "\t");
			System.out.print(list.get(x).getManager() + "\n");
		}
	}
}