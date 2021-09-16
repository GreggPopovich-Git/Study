package oracle.exam;

import oracle.dao.DAO;
import oracle.vo.VO;

public class Problem_04 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		VO vo = dao.getList_04();
		System.out.println("이름\t부서번호");

		System.out.print(vo.getEname() + "\t");
		System.out.print(vo.getDno() + "\n");

	}

}
