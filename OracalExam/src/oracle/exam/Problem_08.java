package oracle.exam;

import java.util.List;

import oracle.dao.DAO;
import oracle.vo.VO;

public class Problem_08 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		List<VO> list = dao.getList_08();
		System.out.println("이름\t급여\t부서번호");
		
		for(int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getEname() + "\t");
			System.out.print(list.get(x).getSalary() + "\t");
			System.out.print(list.get(x).getDno() + "\n");
		}
		
	}

}
