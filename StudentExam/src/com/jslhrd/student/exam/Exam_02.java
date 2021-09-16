package com.jslhrd.student.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jslhrd.student.dao.StudentDAO;
import com.jslhrd.student.vo.StudentVO;

public class Exam_02 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		StudentVO vo = new StudentVO();
		StudentDAO dao = new StudentDAO();
		
		System.out.println("학생 등록 화면");
		System.out.print("학년 : ");
		vo.setSyear(scn.next());
		System.out.print("반 : ");
		vo.setSclass(scn.next());
		System.out.print("번호 : ");
		vo.setSno(scn.next());
		System.out.print("이름 : ");
		vo.setSname(scn.next());
		System.out.print("생년월일 : ");
		vo.setBirth(scn.next());
		System.out.print("성별(M/F) : ");
		vo.setGender(scn.next());
		System.out.print("전화번호 : ");
		vo.setTel1(scn.next());
		vo.setTel2(scn.next());
		vo.setTel3(scn.next());
		
		int row = dao.insertStudent(vo);
		if(row == 1)
			System.out.println("등록되었습니다.");
		else
			System.out.println("등록 실패 하였습니다.");
		
		List<StudentVO> list = new ArrayList<StudentVO>();
		list = dao.selectStudent();
		
		System.out.println("학년\t반\t번호\t이름\t생년월일\t\t성별\t전화1\t전화2\t전화3");
		for(int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getSyear() + "\t");
			System.out.print(list.get(x).getSclass() + "\t");
			System.out.print(list.get(x).getSno() + "\t");
			System.out.print(list.get(x).getSname() + "\t");
			System.out.print(list.get(x).getBirth() + "\t");
			System.out.print(list.get(x).getGender() + "\t");
			System.out.print(list.get(x).getTel1() + "\t");
			System.out.print(list.get(x).getTel2() + "\t");
			System.out.print(list.get(x).getTel3() + "\n");
		}
		scn.close();
		
	}

}
