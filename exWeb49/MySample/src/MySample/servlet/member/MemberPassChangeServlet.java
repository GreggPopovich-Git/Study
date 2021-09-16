package MySample.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySample.model.member.MemberDAO;
import MySample.util.UserSHA256;

@WebServlet("/newpass.do")
public class MemberPassChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberPassChangeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("key", request.getParameter("key"));
		request.setAttribute("userid", request.getParameter("id"));
		RequestDispatcher rd = request.getRequestDispatcher("member/newpass.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int row = 99;
		if(request.getParameter("pass") != null) {
			String userid = request.getParameter("userid");
			String pass = UserSHA256.getSHA256(request.getParameter("pass"));
			MemberDAO dao = MemberDAO.getInstance();
			row = dao.passModify(userid, pass);
		}
		request.setAttribute("row", row);
		request.setAttribute("key", request.getParameter("key"));
		request.setAttribute("userid", request.getParameter("userid"));
		doGet(request, response);
	}

}
