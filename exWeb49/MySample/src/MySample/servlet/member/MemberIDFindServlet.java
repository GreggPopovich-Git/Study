package MySample.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySample.model.member.MemberDAO;

@WebServlet("/idfind.do")
public class MemberIDFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberIDFindServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("member/idfind.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = "";
		if(request.getParameter("email2") == null) {
			email = request.getParameter("email1") + "@" + request.getParameter("domain");
		} else {
			email = request.getParameter("email1") + "@" + request.getParameter("email2");
		}
		String tel = request.getParameter("tel1") + "-" + request.getParameter("tel2") + "-" + request.getParameter("tel3");
		MemberDAO dao = MemberDAO.getInstance();
		String userid = dao.idfind(email, tel);
		
		int length = userid.length() - 3;
		if(userid != "") {
			userid = userid.substring(0,3);
			for(int x = 0; x < length; x++) {
				userid = userid + "*";
			}
		}
		request.setAttribute("userid", userid);
		doGet(request, response);
	}

}
