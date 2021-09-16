package exam;

import java.util.List;
import java.util.Scanner;

import dao.BoardDAO;
import dao.BoardVO;

public class Exam_01 {

	public static void main(String[] args) {
		BoardDAO dao = BoardDAO.getInstance();
		int pageList = 10;
		int totcount = dao.boardCount();
		System.out.println(totcount);
		int totpage = totcount / pageList;
		if (totcount % pageList != 0)
			totpage++;
		System.out.println("총 페이지 수 : " + totpage);
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.print("페이지 번호 : ");
			int nowpage = scn.nextInt();
			if (nowpage == 0 || nowpage > totpage)
				break;
			int startPage = (nowpage - 1) * pageList; // 시작 번호 구하기
			int listcount = totcount - startPage;
			List<BoardVO> list = dao.getList(startPage, pageList);
			System.out.println("글번호\t작성자\t조회수\t작성일자");
			for (int x = 0; x < list.size(); x++) {
				//System.out.print(list.get(x).getBno() + "\t");
				System.out.print((listcount--) + "\t");
				System.out.print(list.get(x).getWriter() + "\t");
				System.out.print(list.get(x).getReadcnt() + "\t");
				System.out.print(list.get(x).getRegdate() + "\n");
			}
		}
		scn.close();
	}
}