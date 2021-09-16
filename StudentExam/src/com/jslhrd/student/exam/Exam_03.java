package com.jslhrd.student.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jslhrd.student.dao.ScoreDAO;
import com.jslhrd.student.vo.StudentVO;

public class Exam_03 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		StudentVO vo = new StudentVO();
		ScoreDAO dao = new ScoreDAO();
		
		System.out.println("학생 점수 등록 화면");
		System.out.print("학년 : ");
		vo.setSyear(scn.next());
		System.out.print("반 : ");
		vo.setSclass(scn.next());
		System.out.print("번호 : ");
		vo.setSno(scn.next());
		System.out.print("국어 : ");
		vo.setKor(scn.nextInt());
		System.out.print("영어 : ");
		vo.setEng(scn.nextInt());
		System.out.print("수학 : ");
		vo.setMat(scn.nextInt());
		
		int row = dao.insertScore(vo);
		if(row == 1)
			System.out.println("등록되었습니다.");
		else
			System.out.println("등록 실패 하였습니다.");
		
		List<StudentVO> list = new ArrayList<StudentVO>();
		list = dao.selectScore();
		System.out.println("학년\t반\t번호\t국어\t영어\t수학\t총점\t평균");
		for(int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getSyear() + "\t");
			System.out.print(list.get(x).getSclass() + "\t");
			System.out.print(list.get(x).getSno() + "\t");
			System.out.print(list.get(x).getKor() + "\t");
			System.out.print(list.get(x).getEng() + "\t");
			System.out.print(list.get(x).getMat() + "\t");
			int tot = list.get(x).getKor() + list.get(x).getEng() + list.get(x).getMat();
			double ave = (int)(tot / 3. * 100 + 0.5) / 100.;
			System.out.println(tot + "\t" + ave);
		}
		scn.close();
		
	}

}
