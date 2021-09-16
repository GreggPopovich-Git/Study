package service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import service.CommandHandler;

public class BoardDeleteProHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		String pass = request.getParameter("pass");
		
		BoardDAO dao = BoardDAO.getInstance();
		int row = dao.boardDelete(idx,pass);
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);
		
		return "/Board/board_delete_pro.jsp";
	}

}
