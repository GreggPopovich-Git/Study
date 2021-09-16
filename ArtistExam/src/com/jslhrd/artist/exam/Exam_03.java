package com.jslhrd.artist.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jslhrd.artist.dao.PointDAO;
import com.jslhrd.artist.vo.PointVO;

public class Exam_03 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		PointVO vo = new PointVO();
		PointDAO dao = new PointDAO();
		
		System.out.println("심사위원 채첨결과 등록화면");
		System.out.print("채점번호 : ");
		vo.setSerial_no(scn.nextInt());
		System.out.print("참가번호 : ");
		vo.setArtist_id(scn.next());
		System.out.print("멘토아이디 : ");
		vo.setMento_id(scn.next());
		System.out.print("점수 : ");
		vo.setPoint(scn.nextInt());
		
		int row = dao.insertPoint(vo);
		if(row == 1)
			System.out.println("등록되었습니다.");
		else
			System.out.println("등록에 실패 하였습니다.");
		List<PointVO> list = new ArrayList<PointVO>();
		list = dao.selectPoint();
		System.out.println("순서\t채점번호\t참가번호\t멘토아이디\t점수");
		for (int x = 0; x < list.size(); x++) {
			System.out.print(x+1 +"\t");
			System.out.print(list.get(x).getSerial_no() + "\t");
			System.out.print(list.get(x).getArtist_id() + "\t");
			System.out.print(list.get(x).getMento_id() + "\t");
			System.out.print(list.get(x).getPoint() + "\n");
		}
		scn.close();
	}

}
