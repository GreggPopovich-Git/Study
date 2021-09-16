package servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDAO;
import model.vo.MemberVO;
import util.UserSHA256;

@WebServlet("/login_form")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberLoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/Member/login_form.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String passwd = UserSHA256.getSHA256(request.getParameter("pass"));
		MemberDAO dao = MemberDAO.getInstance();
		int row = dao.userLogin(userid, passwd);
		request.setAttribute("row", row);
		if(row == 1) { // 로그인 성공
			MemberVO vo = dao.getMember(userid);
			HttpSession session = request.getSession();
			session.setAttribute("vo", vo);
			session.setMaxInactiveInterval(600); // 10분
		}
		response.sendRedirect("index?row=" + row);
	}

}
