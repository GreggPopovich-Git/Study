package com.jslhrd.artist.exam;

import java.util.ArrayList;
import java.util.List;

import com.jslhrd.artist.dao.ArtistDAO;
import com.jslhrd.artist.vo.ArtistVO;

public class Exam_02 {

	public static void main(String[] args) {
		List<ArtistVO> list = new ArrayList<ArtistVO>();
		ArtistDAO dao = new ArtistDAO();
		list = dao.selectArtist();
		
		System.out.println("순서\t참가번호\t참가자명\t생년월일\t\t성별\t특기\t소속사");
		for(int x = 0; x < list.size(); x++) {
			System.out.print(x+1 + "\t");
			System.out.print(list.get(x).getArtist_id() + "\t");
			System.out.print(list.get(x).getArtist_name() + "\t");
			String year = list.get(x).getArtist_birth().substring(0,4);
			String month = list.get(x).getArtist_birth().substring(4,6);
			String day = list.get(x).getArtist_birth().substring(6);
			System.out.print(year + "년" + month + "월" + day + "일" + "\t");
			String gender;
			if(list.get(x).getArtist_gender().equalsIgnoreCase("M"))
				gender = "남";
			else
				gender = "여";
			System.out.print(gender + "\t");
			String talent = null;
			switch(list.get(x).getTalent()) {
			case "1":
				talent = "댄스";
				break;
			case "2":
				talent = "노래";
				break;
			case "3":
				talent = "랩";
				break;
			}
			
			System.out.print(talent + "\t");
			System.out.print(list.get(x).getAgency() + "\n");
		}
		
	}

}
