package oracle.exam;

import java.util.List;

import oracle.dao.DAO;
import oracle.vo.VO;

public class Problem_16 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		List<VO> list = dao.getList_16();
		System.out.println("사번\t이름\t업무명\t관리번호\t고용날짜\t급여\t커미션");

		for (int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getEno() + "\t");
			System.out.print(list.get(x).getEname() + "\t");
			System.out.print(list.get(x).getJob() + "\t");
			System.out.print(list.get(x).getManager() + "\t");
			System.out.print(list.get(x).getHiredate() + "\t");
			System.out.print(list.get(x).getSalary() + "\t");
			System.out.print(list.get(x).getCommission() + "\n");
		}
	}

}
