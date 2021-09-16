package service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;
import service.CommandHandler;
import util.UserSHA256;

public class BoardModifyProHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		BoardVO vo = new BoardVO();
		int row = 0;
		if(request.getParameter("name") != null) {
			vo.setIdx(Integer.parseInt(request.getParameter("idx")));
			vo.setName(request.getParameter("name"));
			vo.setPass(UserSHA256.getSHA256(request.getParameter("pass")));
			vo.setSubject(request.getParameter("subject"));
			vo.setContents(request.getParameter("contents"));
			BoardDAO dao = BoardDAO.getInstance();
			row = dao.boardModify(vo);
		}
		request.setAttribute("idx", vo.getIdx());
		request.setAttribute("modifyrow", row);
		return "/board/board_modify.jsp";
	}

}
