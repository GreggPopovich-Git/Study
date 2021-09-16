package com.jslhrd.student.exam;

import java.util.ArrayList;
import java.util.List;

import com.jslhrd.student.dao.StudentDAO;
import com.jslhrd.student.vo.StudentVO;

public class Exam_05 {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		List<StudentVO> list = new ArrayList<StudentVO>();
		list = dao.deletePrint();
		System.out.println("\t\t\t학생 성적 조회 화면");
		System.out.println("학년-반-번호\t이름\t성별\t국어\t영어\t수학\t총점\t평균");
		int kortot = 0, engtot = 0, mattot = 0;
		double korave = 0., engave = 0., matave = 0.;
		for(int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getSyear() + "-");
			System.out.print(list.get(x).getSclass() + "-");
			System.out.print(list.get(x).getSno() + "\t\t");
			System.out.print(list.get(x).getSname() + "\t");
			System.out.print(list.get(x).getGender() + "\t");
			System.out.print(list.get(x).getKor() + "\t");
			System.out.print(list.get(x).getEng() + "\t");
			System.out.print(list.get(x).getMat() + "\t");
			int tot = list.get(x).getKor() + list.get(x).getEng() + list.get(x).getMat();
			double ave = (int)(tot / 3. * 100 + 0.5) / 100.;
			System.out.println(tot + "\t" + ave);
			
			kortot += list.get(x).getKor();
			engtot += list.get(x).getEng();
			mattot += list.get(x).getMat();
		}
		System.out.println("\t\t\t학년총점\t" + kortot + "\t" + engtot + "\t" + mattot);
		korave = (int)(kortot / (double)list.size() * 10 + 0.5) / 10.;
		engave = (int)(engtot / (double)list.size() * 10 + 0.5) / 10.;
		matave = (int)(mattot / (double)list.size() * 10 + 0.5) / 10.;
		System.out.println("\t\t\t학년평균\t" + korave + "\t" + engave + "\t" + matave);
		
	}

}