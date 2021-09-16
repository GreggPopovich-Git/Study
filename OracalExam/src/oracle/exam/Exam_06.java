package oracle.exam;

import java.util.List;

import oracle.dao.DAO2;
import oracle.vo.VO;

public class Exam_06 {

	public static void main(String[] args) {
		DAO2 dao = DAO2.getInstance();
		List<VO> list = dao.exam_6();
		System.out.println("JOB\t\tMIN(SALARY)");
		
		for(int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getJob() + "\t");
			if(list.get(x).getJob().length() < 8)
				System.out.print("\t");
			System.out.print(list.get(x).getEno() + "\n");
		}
		
	}

}