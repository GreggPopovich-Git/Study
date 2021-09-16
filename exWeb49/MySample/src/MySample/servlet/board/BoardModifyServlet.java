package MySample.servlet.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySample.model.board.BoardDAO;
import MySample.model.board.BoardVO;
import MySample.util.UserSHA256;

@WebServlet("/board_modify.do")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardModifyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.getBoard(Integer.parseInt(request.getParameter("idx")));
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("board/board_modify.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		RequestDispatcher rd = request.getRequestDispatcher("board/board_modify.jsp");
		rd.forward(request, response);

	}
}