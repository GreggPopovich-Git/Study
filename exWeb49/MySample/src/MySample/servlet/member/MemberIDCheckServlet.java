package MySample.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySample.model.member.MemberDAO;

@WebServlet("/idcheck.do")
public class MemberIDCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberIDCheckServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/member/idcheck.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		MemberDAO dao = MemberDAO.getInstance();
		int row = dao.idcheck(userid);
		request.setAttribute("userid", userid);
		request.setAttribute("row", row);
		doGet(request, response);
	}

}
