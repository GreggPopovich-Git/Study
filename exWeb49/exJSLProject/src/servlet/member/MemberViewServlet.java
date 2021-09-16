package servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDAO;
import util.UserSHA256;

@WebServlet("/member_view")
public class MemberViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberViewServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Member/member_view.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nowpass = UserSHA256.getSHA256(request.getParameter("nowpass"));
		String pass = UserSHA256.getSHA256(request.getParameter("pass"));
		String userid = request.getParameter("userid");
		MemberDAO dao = MemberDAO.getInstance();
		int row = dao.passModify(userid, nowpass, pass);
		if(row == 1) {
			response.sendRedirect("logout?row=" + row);
		} else {
			response.sendRedirect("index?row=" + row);
		}
	}

}
