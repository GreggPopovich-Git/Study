package oracle.exam;

import java.util.List;

import oracle.dao.DAO2;
import oracle.vo.VO;

public class Exam_04 {

	public static void main(String[] args) {
		DAO2 dao = DAO2.getInstance();
		List<VO> list = dao.exam_4();
		System.out.println("CNT(MANAGER)");
		
		for(int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getEno() + "\n");
		}
		
	}

}