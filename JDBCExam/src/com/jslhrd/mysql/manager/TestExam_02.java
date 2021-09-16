package com.jslhrd.mysql.manager;

import java.util.List;

public class TestExam_02 {

	public static void main(String[] args) {
		TestSQL test = new TestSQL();
		
		List<DeptVO> list = test.deptList();
		System.out.println("부서\t이름\t\t지역");
		for (int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getDno() + "\t");
			System.out.print(list.get(x).getDname() + "\t");
			if(list.get(x).getDname().length() < 6)
				System.out.print("\t");
			System.out.print(list.get(x).getLoc() + "\n");
		}
	}
}