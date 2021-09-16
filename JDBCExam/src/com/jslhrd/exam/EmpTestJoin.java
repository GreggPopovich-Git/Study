package com.jslhrd.exam;

import java.util.List;

import com.jslhrd.dao.EmpDAO;
import com.jslhrd.vo.EmpVO;

public class EmpTestJoin {

	public static void main(String[] args) {
		EmpDAO dao = EmpDAO.getInstance();
		List<EmpVO> eList = dao.empDeptList();
		System.out.println("사번\t이름\t입사일\t\t급여\t부서명");
		for(int x = 0; x < eList.size(); x++) {
			System.out.print(eList.get(x).getEno() + "\t");
			System.out.print(eList.get(x).getEname() + "\t");
			System.out.print(eList.get(x).getHiredate() + "\t");
			System.out.print(eList.get(x).getSalary() + "\t");
			System.out.print(eList.get(x).getDname() + "\n");
		}

	}

}
