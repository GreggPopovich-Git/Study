package com.jslhrd.artist.exam;

import java.util.Scanner;

import com.jslhrd.artist.dao.ArtistDAO;
import com.jslhrd.artist.vo.ArtistVO;

public class Exam_01 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		ArtistVO vo = new ArtistVO();
		ArtistDAO dao = new ArtistDAO();
		
		System.out.println("오디션 지원자 정보 등록 화면");
		System.out.print("참가번호 : ");
		vo.setArtist_id(scn.next());
		System.out.print("이름 : ");
		vo.setArtist_name(scn.next());
		System.out.print("성별 : ");
		vo.setArtist_gender(scn.next());
		System.out.print("생년월일 : ");
		vo.setArtist_birth(scn.next());
		System.out.print("특기 : ");
		vo.setTalent(scn.next());
		System.out.print("소속사 : ");
		vo.setAgency(scn.next());
		
		int row = dao.insertArtist(vo);
		if(row == 1)
			System.out.println("등록되었습니다.");
		else
			System.out.println("등록 실패 하였습니다.");
		
		scn.close();
	}

}
