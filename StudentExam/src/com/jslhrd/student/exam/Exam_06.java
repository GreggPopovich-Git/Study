package com.jslhrd.student.exam;

import java.util.ArrayList;
import java.util.List;

import com.jslhrd.student.dao.ScoreDAO;
import com.jslhrd.student.vo.StudentVO;

public class Exam_06 {

	public static void main(String[] args) {
		ScoreDAO dao = new ScoreDAO();
		List<StudentVO> list = new ArrayList<StudentVO>();
		list = dao.totavePrint();
		System.out.println("학년\t반\t교사명\t국어총점\t영어총점\t수학총점\t국어평균\t영어평균\t수학평균");
		for(int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getSyear() + "\t");
			System.out.print(list.get(x).getSclass() + "\t");
			System.out.print(list.get(x).getTname() + "\t");
			System.out.print(list.get(x).getKor() + "\t");
			System.out.print(list.get(x).getEng() + "\t");
			System.out.print(list.get(x).getMat() + "\t");
			System.out.print(list.get(x).getKorave() + "\t");
			System.out.print(list.get(x).getEngave() + "\t");
			System.out.print(list.get(x).getMatave() + "\n");
		}
	}
}