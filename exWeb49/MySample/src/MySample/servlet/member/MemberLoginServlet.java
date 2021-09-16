package MySample.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MySample.model.member.MemberDAO;
import MySample.model.member.MemberVO;
import MySample.util.UserSHA256;

@WebServlet("/login.do")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberLoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("member/login.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String pass = UserSHA256.getSHA256(request.getParameter("pass"));
		MemberDAO dao = MemberDAO.getInstance();
		int row = dao.userLogin(userid, pass);
		if(row == 1) {
			MemberVO vo = dao.getMember(userid);
			HttpSession session = request.getSession();
			session.setAttribute("sessionvo", vo);
			session.setMaxInactiveInterval(1800); // 30분
		}
		request.setAttribute("row", row);
		doGet(request, response);
	}

}
