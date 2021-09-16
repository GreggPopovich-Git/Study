package service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;
import service.CommandHandler;

public class BoardModifyHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.getBoard(Integer.parseInt(request.getParameter("idx")));
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		request.setAttribute("vo", vo);
		return "/board/board_modify.jsp";
	}

}
