package com.jslhrd.artist.exam;

import java.util.ArrayList;
import java.util.List;

import com.jslhrd.artist.dao.JoinDAO;
import com.jslhrd.artist.vo.AllVO;

public class Exam_06 {

	public static void main(String[] args) {
		JoinDAO dao = new JoinDAO();
		List<AllVO> list = new ArrayList<AllVO>();
		list = dao.joinPrint();
		System.out.println("\t\t\t멘토 점수 목록 조회");
		System.out.println("채점번호\t참가번호\t참가자명\t생년월일\t\t점수\t평점\t멘토");
		for (int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getSerial_no() + "\t");
			System.out.print(list.get(x).getArtist_id() + "\t");
			System.out.print(list.get(x).getArtist_name() + "\t");
			String year = list.get(x).getArtist_birth().substring(0,4);
			String month = list.get(x).getArtist_birth().substring(4,6);
			String day = list.get(x).getArtist_birth().substring(6);
			System.out.print(year + "년" + month + "월" + day + "일" + "\t");
			System.out.print(list.get(x).getPoint() + "\t");
			String grade = "";
			if(list.get(x).getPoint() >= 90)
				grade = "A";
			else if(list.get(x).getPoint() >= 80)
				grade = "B";
			else if(list.get(x).getPoint() >= 70)
				grade = "C";
			else if(list.get(x).getPoint() >= 60)
				grade = "D";
			else
				grade = "F";
			System.out.print(grade + "\t");
			System.out.print(list.get(x).getMento_name() + "\n");
		}
	}

}
