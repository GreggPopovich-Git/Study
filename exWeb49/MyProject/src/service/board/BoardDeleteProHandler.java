package service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import service.CommandHandler;
import util.UserSHA256;

public class BoardDeleteProHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pass = UserSHA256.getSHA256(request.getParameter("pass"));
		BoardDAO dao = BoardDAO.getInstance();
		int row = dao.boardDelete(idx, pass);
		request.setAttribute("deleterow", row);
		return "/board/board_delete.jsp";
	}

}
