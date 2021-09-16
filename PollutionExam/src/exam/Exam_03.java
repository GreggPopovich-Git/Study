package exam;

import java.util.Scanner;

import dao.DAO;
import vo.VO;

public class Exam_03 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		VO vo = new VO();
		Scanner scn = new Scanner(System.in);
		System.out.println("대기오염측정등록화면");
		System.out.print("관측일자 : ");
		vo.setTest_date(scn.next());
		System.out.print("측정시기(오전:AM, 오후:PM) : ");
		vo.setTest_ampm(scn.next());
		System.out.print("대기오염코드(P1:미세먼지, P2:오존, P3:자외선, P4:황사) : ");
		vo.setPollution(scn.next());
		System.out.print("관측지점번호 : ");
		vo.setCity_code(scn.next());
		System.out.print("측정값 : ");
		vo.setTest_value(scn.nextInt());
		
		int row = dao.exam_3(vo);
		if(row == 1)
			System.out.println("등록되었습니다.");
		else
			System.out.println("등록에 실패 하였습니다.");
		scn.close();
	}

}
