package oracle.exam;

import oracle.dao.DAO;
import oracle.vo.VO;

public class Problem_10 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		VO vo = dao.getList_10();
		System.out.println("이름\t업무명");

		System.out.print(vo.getEname() + "\t");
		System.out.print(vo.getJob() + "\n");

	}

}
