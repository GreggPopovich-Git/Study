package oracle.exam;

import java.util.List;

import oracle.dao.DAO2;
import oracle.vo.VO;

public class Exam_07 {

	public static void main(String[] args) {
		DAO2 dao = DAO2.getInstance();
		List<VO> list = dao.exam_7();
		System.out.println("DNO\tCNT\tSalary");
		
		for(int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getDno() + "\t");
			System.out.print(list.get(x).getEno() + "\t");
			System.out.print(list.get(x).getSalary() + "\n");
		}
		
	}

}