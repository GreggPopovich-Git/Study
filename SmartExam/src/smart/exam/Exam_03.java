package smart.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import smart.dao.SmartDao;
import smart.vo.SmartVO;

public class Exam_03 {

	public static void main(String[] args) {
		SmartDao dao = SmartDao.getInstance();
		SmartVO vo = new SmartVO();
		Scanner scn = new Scanner(System.in);
		System.out.println("작업공정등록화면");
		System.out.print("작업지시번호 : ");
		vo.setW_workno(scn.next());
		System.out.print("재료준비 : ");
		vo.setP_p1(scn.next());
		System.out.print("인쇄공정 : ");
		vo.setP_p2(scn.next());
		System.out.print("코팅공정 : ");
		vo.setP_p3(scn.next());
		System.out.print("합지공정 : ");
		vo.setP_p4(scn.next());
		System.out.print("접합공정 : ");
		vo.setP_p5(scn.next());
		System.out.print("포장적재 : ");
		vo.setP_p6(scn.next());
		System.out.print("최종작업일자 : ");
		vo.setW_lastdate(scn.next());
		System.out.print("최종작업시간 : ");
		vo.setW_lasttime(scn.next());
		
		int row = dao.exam_03_1(vo);
		if(row == 1)
			System.out.println("등록되었습니다.");
		else
			System.out.println("등록에 실패 했습니다.");
		List<SmartVO> list = new ArrayList<SmartVO>();
		list = dao.exam_03_2();
		System.out.println("작업지시번호\t준비\t인쇄\t코팅\t합지\t접합\t포장\t최종공정일자\t최종공정시간");
		for(int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getW_workno() + "\t");
			System.out.print(list.get(x).getP_p1() + "\t");
			System.out.print(list.get(x).getP_p2() + "\t");
			System.out.print(list.get(x).getP_p3() + "\t");
			System.out.print(list.get(x).getP_p4() + "\t");
			System.out.print(list.get(x).getP_p5() + "\t");
			System.out.print(list.get(x).getP_p6() + "\t");
			System.out.print(list.get(x).getW_lastdate() + "\t");
			System.out.print(list.get(x).getW_lasttime() + "\n");
		}
		scn.close();
	}

}
