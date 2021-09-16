package service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.board.BoardDAO;
import model.board.BoardVO;
import model.member.MemberVO;
import service.CommandHandler;
import util.UserSHA256;

public class BoardWriteProHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int row = 0;
		BoardVO vo = new BoardVO();
		if(session.getAttribute("sessionvo") != null) {
			MemberVO member = new MemberVO();
			member = (MemberVO)session.getAttribute("sessionvo");
			vo.setUserid(member.getUserid());
		}
		if(request.getParameter("name") != null) {
			vo.setName(request.getParameter("name"));
			vo.setPass(UserSHA256.getSHA256(request.getParameter("pass")));
			vo.setSubject(request.getParameter("subject"));
			vo.setContents(request.getParameter("contents"));
			BoardDAO dao = BoardDAO.getInstance();
			row = dao.boardWrite(vo);
		} else {
			row = -2;
		}
		request.setAttribute("writerow", row);
		
		return "/board/board_write.jsp";
	}

}
