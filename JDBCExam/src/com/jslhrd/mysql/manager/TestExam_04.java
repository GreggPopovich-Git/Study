package com.jslhrd.mysql.manager;

public class TestExam_04 {

	public static void main(String[] args) {
		TestSQL test = new TestSQL();
		// 입력
		int dno = 70;
		String dname = "개발";
		String loc = "군산";
		DeptVO vo = new DeptVO();
		vo.setDno(dno);
		vo.setDname(dname);
		vo.setLoc(loc);
		int row = test.deptInsert(vo);
		if(row == 1)
			System.out.println("등록되었습니다.");
		else
			System.out.println("wait.........");
	}

}