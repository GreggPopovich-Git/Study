package servlet.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.BoardDAO;
import model.vo.BoardVO;
import model.vo.MemberVO;
import util.UserSHA256;

@WebServlet("/board_write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardWriteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int page = Integer.parseInt(request.getParameter("page"));
		MemberVO vo = new MemberVO();
		if(session.getAttribute("vo") != null) {
			vo = (MemberVO) session.getAttribute("vo");
		}
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		RequestDispatcher rd = request.getRequestDispatcher("Board/board_write.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int page = Integer.parseInt(request.getParameter("page"));
		BoardVO vo = new BoardVO();
		vo.setName(request.getParameter("name"));
		if(request.getParameter("email") != null) {
			vo.setEmail(request.getParameter("email"));
		}
		if(request.getParameter("userid") != null) {
			vo.setUserid(request.getParameter("userid"));
		}
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		String pass = UserSHA256.getSHA256(request.getParameter("pass"));
		vo.setPass(pass);
		BoardDAO dao = BoardDAO.getInstance();
		int row = dao.boardWrite(vo);
		request.setAttribute("row", row);
		response.sendRedirect("board_list?page=" + page);
	}

}
