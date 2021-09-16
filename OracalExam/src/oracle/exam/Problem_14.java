package oracle.exam;

import java.util.List;

import oracle.dao.DAO;
import oracle.vo.VO;

public class Problem_14 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		List<VO> list = dao.getList_14();
		System.out.println("이름\t업무명\t\t급여");
		
		for(int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getEname() + "\t");
			System.out.print(list.get(x).getJob() + "\t");
			if(list.get(x).getJob().length() < 6)
				System.out.print("\t");
			System.out.print(list.get(x).getSalary() + "\n");
		}
		
	}

}
