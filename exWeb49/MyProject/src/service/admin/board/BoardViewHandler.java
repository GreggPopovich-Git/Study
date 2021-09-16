package service.admin.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;
import service.CommandHandler;

public class BoardViewHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx"));
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO boardvo = dao.getBoard(idx);
		
		request.setAttribute("boardvo", boardvo);
		return "/Admin/board_view.jsp";
	}

}
