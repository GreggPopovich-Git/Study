package exServletJSTL.servlet.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exServletJSTL.model.board.BoardDAO;
import exServletJSTL.model.board.BoardVO;

@WebServlet("/board_modify.do")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardModifyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO board = dao.boardSelect(idx);
		
		request.setAttribute("page", page);
		request.setAttribute("board", board);
		
		RequestDispatcher dispater = 
				request.getRequestDispatcher("Board/board_modify.jsp");
		dispater.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardVO vo = new BoardVO();
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		vo.setEmail(request.getParameter("email"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		vo.setPass(request.getParameter("pass"));
		
		BoardDAO dao = BoardDAO.getInstance();
		int row = dao.boardUpdate(vo);
		
		response.sendRedirect("board_list.do?page="+page+"&row=" + row);
	}

}
