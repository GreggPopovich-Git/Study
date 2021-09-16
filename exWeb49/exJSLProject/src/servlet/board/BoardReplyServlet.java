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

@WebServlet("/board_reply")
public class BoardReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardReplyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String page = request.getParameter("page");
		int idx = Integer.parseInt(request.getParameter("idx"));
		MemberVO vo = new MemberVO();
		if(session.getAttribute("vo") != null) {
			vo = (MemberVO) session.getAttribute("vo");
		}
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO bvo = dao.boardView(idx);
		String subject = "Re:" + bvo.getSubject();
		int reply = bvo.getReply();
		request.setAttribute("idx", idx);
		request.setAttribute("subject", subject);
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		request.setAttribute("reply", reply);
		RequestDispatcher rd = request.getRequestDispatcher("Board/board_reply.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int page = Integer.parseInt(request.getParameter("page"));
		int reply = Integer.parseInt(request.getParameter("reply"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		BoardVO vo = new BoardVO();
		vo.setIdx(idx);
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
		vo.setReply(reply+1);
		BoardDAO dao = BoardDAO.getInstance();
		int row = dao.boardReply(vo);
		request.setAttribute("row", row);
		response.sendRedirect("board_list?page=" + page);
	}

}
