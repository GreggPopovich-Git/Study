package oracle.exam;

import java.util.List;

import oracle.dao.DAO2;
import oracle.vo.VO;

public class Exam_01 {

	public static void main(String[] args) {
		DAO2 dao = DAO2.getInstance();
		List<VO> list = dao.exam_1();
		System.out.println("MAX\tMIN\tSUM\tAVG");
		
		for(int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getEno() + "\t");
			System.out.print(list.get(x).getSalary() + "\t");
			System.out.print(list.get(x).getSum() + "\t");
			System.out.print(list.get(x).getTot() + "\n");
		}
		
	}

}