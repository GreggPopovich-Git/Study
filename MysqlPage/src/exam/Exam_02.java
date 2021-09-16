package exam;

import java.util.Scanner;

import dao.BoardDAO;
import dao.BoardVO;

public class Exam_02 {

	public static void main(String[] args) {
		BoardDAO dao = BoardDAO.getInstance();
		Scanner scn = new Scanner(System.in);
		System.out.print("글번호 입력 : ");
		int bno = scn.nextInt();
		BoardVO vo = new BoardVO();
		vo = dao.getSelect(bno);
		if(vo == null)
			System.out.println("해당 게시물이 없습니다.");
		else {
			System.out.println("글번호 : " + vo.getBno());
			System.out.println("제목 : " + vo.getTitle());
			System.out.println("글쓴이 : " + vo.getWriter());
			System.out.println("내용 : " + vo.getContents());
			System.out.println("조회수 : " + vo.getReadcnt());
			System.out.println("게시날짜 : " + vo.getRegdate());
		}
		scn.close();
	}
}