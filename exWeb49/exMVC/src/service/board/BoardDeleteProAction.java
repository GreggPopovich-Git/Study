package service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import service.Action;

public class BoardDeleteProAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		String pass = request.getParameter("pass");
		
		BoardDAO dao = BoardDAO.getInstance();
		int row = dao.boardDelete(idx,pass);
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);

		RequestDispatcher dispater = 
				request.getRequestDispatcher("Board/board_delete_pro.jsp");
		dispater.forward(request, response);
	}

}
