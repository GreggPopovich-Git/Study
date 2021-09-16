package com.jslhrd.exam;

import java.util.List;
import java.util.Scanner;

import com.jslhrd.vo.EmpVO;

// View 처리 전용 클래스
public class EmpView {
	// emp 테이블의 전체 tuple(레코드) 출력용 메소드
	public void empList(List<EmpVO> list) {
		System.out.println("사원번호\t이름\t업무명\t\t상사\t입사일자\t\t급여\t커미션\t부서코드");
		for(int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getEno() + "\t");
			System.out.print(list.get(x).getEname() + "\t");
			System.out.print(list.get(x).getJob() + "\t");
			System.out.print(list.get(x).getManager() + "\t");
			System.out.print(list.get(x).getHiredate() + "\t");
			System.out.print(list.get(x).getSalary() + "\t");
			System.out.print(list.get(x).getCommission() + "\t");
			System.out.print(list.get(x).getDno() + "\n");
		}
	}
	// 사원등록 화면
	public EmpVO empInsert() {
		Scanner scn = new Scanner(System.in);
		EmpVO vo = new EmpVO();
		System.out.println("사원정보 등록화면");
		System.out.print("사원번호 : ");
		vo.setEno(scn.nextInt());
		System.out.print("사원이름 : ");
		vo.setEname(scn.next());
		System.out.print("급여 : ");
		vo.setSalary(scn.nextInt());
		System.out.print("부서코드 : ");
		vo.setDno(scn.nextInt());
		return vo;
	}
	// 사원번호 입력화면 (데이터 검색)
	public int sabunSearch() {
		Scanner scn = new Scanner(System.in);
		System.out.println("사원정보 검색화면");
		System.out.print("사원번호 : ");
		int eno = scn.nextInt();
		return eno;
	}
	// 사원정보 출력화면
	public void sawonPrint(EmpVO vo) {
		System.out.println("사원번호 : " + vo.getEno());
		System.out.println("사원이름 : " + vo.getEname());
		System.out.println("업무명 : " + vo.getJob());
		System.out.println("상사번호 : " + vo.getManager());
		System.out.println("입사일자 : " + vo.getHiredate());
		System.out.println("급여 : " + vo.getSalary());
		System.out.println("커미션 : " + vo.getCommission());
		System.out.println("부서번호 : " + vo.getDno());
	}
	// 수정할 데이터 입력 화면
	public EmpVO updatedata() {
		Scanner scn = new Scanner(System.in);
		EmpVO vo = new EmpVO();
		System.out.println("사원정보 수정화면");
		System.out.print("사원번호 : ");
		vo.setEno(scn.nextInt());
		System.out.print("사원이름 : ");
		vo.setEname(scn.next());
		System.out.print("업무명 : ");
		vo.setJob(scn.next());
		System.out.print("상사번호 : ");
		vo.setManager(scn.nextInt());
		System.out.print("급여 : ");
		vo.setSalary(scn.nextInt());
		System.out.print("커미션 : ");
		vo.setCommission(scn.nextInt());
		return vo;
	}
	// 삭제할 사원 번호 입력 화면
	public int sabunDelete() {
		Scanner scn = new Scanner(System.in);
		System.out.println("사원정보 검색화면");
		System.out.print("사원번호 : ");
		int eno = scn.nextInt();
		return eno;
	}
}