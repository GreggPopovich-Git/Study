package servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDAO;

@WebServlet("/id_check")
public class IDCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public IDCheckServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Member/id_check.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = "";
		if(request.getParameter("userid") != null) {
			userid = request.getParameter("userid");
		}
		
		MemberDAO dao = MemberDAO.getInstance();
		int idcheck = dao.idCheck(userid);
		request.setAttribute("userid", userid);
		request.setAttribute("idcheck", idcheck);
		doGet(request, response);
	}

}
