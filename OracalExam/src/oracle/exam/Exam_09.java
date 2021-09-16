package oracle.exam;

import java.util.List;

import oracle.dao.DAO2;
import oracle.vo.VO;

public class Exam_09 {

	public static void main(String[] args) {
		DAO2 dao = DAO2.getInstance();
		List<VO> list = dao.exam_9();
		System.out.println("JOB\t\tDNO\tD10\tD20\tD30\tTOT");

		for (int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getJob() + "\t");
			if (list.get(x).getJob().length() < 8)
				System.out.print("\t");
			System.out.print(list.get(x).getDno() + "\t");
			if (list.get(x).getSalary() == 0)
				System.out.print("\t");
			else
				System.out.print(list.get(x).getSalary() + "\t");
			if (list.get(x).getSum() == 0)
				System.out.print("\t");
			else
				System.out.print(list.get(x).getSum() + "\t");
			if (list.get(x).getTot() == 0)
				System.out.print("\t");
			else
				System.out.print(list.get(x).getTot() + "\t");
			System.out.print(list.get(x).getManager() + "\n");
		}

	}

}