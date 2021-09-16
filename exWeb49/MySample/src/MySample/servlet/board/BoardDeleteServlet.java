package MySample.servlet.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySample.model.board.BoardDAO;
import MySample.util.UserSHA256;

@WebServlet("/board_delete.do")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardDeleteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		request.setAttribute("idx", idx);
		RequestDispatcher rd = request.getRequestDispatcher("board/board_delete.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pass = UserSHA256.getSHA256(request.getParameter("pass"));
		BoardDAO dao = BoardDAO.getInstance();
		int row = dao.boardDelete(idx, pass);
		request.setAttribute("deleterow", row);
		
		doGet(request, response);
	}

}
