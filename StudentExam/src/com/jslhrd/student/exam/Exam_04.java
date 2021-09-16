package com.jslhrd.student.exam;

import java.util.Scanner;

import com.jslhrd.student.dao.StudentDAO;
import com.jslhrd.student.vo.StudentVO;

public class Exam_04 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		StudentVO vo = new StudentVO();
		StudentDAO dao = new StudentDAO();
		
		System.out.println("학생 정보 삭제");
		System.out.print("학번입력 : ");
		String temp = scn.next();
		String syear = temp.substring(0,1);
		String sclass = temp.substring(1,3);
		String sno = temp.substring(3);
		
		vo.setSyear(syear);
		vo.setSclass(sclass);
		vo.setSno(sno);
		
		dao.deleteScore(vo);
		
		scn.close();
	}

}
