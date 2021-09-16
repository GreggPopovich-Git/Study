package servlet.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDAO;
import model.vo.BoardVO;
import util.UserSHA256;

@WebServlet("/board_modify")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardModifyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		String sort = request.getParameter("sort");
		BoardVO vo = new BoardVO();
		BoardDAO dao = BoardDAO.getInstance();
		
		vo = dao.boardView(idx);
		vo.setIdx(idx);
		request.setAttribute("sort", sort);
		request.setAttribute("vo", vo);
		request.setAttribute("length", vo.getContents().length());
		request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("Board/board_modify.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int page = Integer.parseInt(request.getParameter("page"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		BoardVO aftervo = new BoardVO();
		BoardDAO dao = BoardDAO.getInstance();
		aftervo.setName(request.getParameter("name"));
		if(request.getParameter("email") != null) {
			aftervo.setEmail(request.getParameter("email"));
		}
		aftervo.setSubject(request.getParameter("subject"));
		aftervo.setContents(request.getParameter("contents"));
		String pass = UserSHA256.getSHA256(request.getParameter("pass"));
		BoardVO beforevo = dao.boardView(idx);
		beforevo.setIdx(idx);
		aftervo.setIdx(beforevo.getIdx());
		aftervo.setPass(pass);
		int row = 0;
		if(pass.equals(beforevo.getPass())) { // 비밀번호 비교
			dao.boardModify(aftervo);
			row = 1; // 수정했을 때 결과값
		} else {
			row = -1; // 비밀번호 틀렸을 때 결과값
		}
		response.sendRedirect("board_view?page=" + page + "&idx=" + idx + "&row=" + row);
	}

}
