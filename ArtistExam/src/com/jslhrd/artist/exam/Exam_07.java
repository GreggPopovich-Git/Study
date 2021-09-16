package com.jslhrd.artist.exam;

import java.util.ArrayList;
import java.util.List;

import com.jslhrd.artist.dao.JoinDAO;
import com.jslhrd.artist.vo.AllVO;

public class Exam_07 {
	public static void main(String[] args) {
		JoinDAO dao = new JoinDAO();
		List<AllVO> list = new ArrayList<AllVO>();
		list = dao.avePrint();

		System.out.println("\t\t참가자 등수 조회");
		System.out.println("참가번호\t참가자명\t성별\t총점\t평균\t등수");
		for (int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getArtist_id() + "\t");
			System.out.print(list.get(x).getArtist_name() + "\t");
			String gender;
			if (list.get(x).getArtist_gender().equalsIgnoreCase("M"))
				gender = "남성";
			else
				gender = "여성";
			System.out.print(gender + "\t");
			System.out.print(list.get(x).getPoint() + "\t");
			System.out.print(list.get(x).getAgency() + "\t");
			System.out.print(x + 1 + "\n");
		}
	}
}