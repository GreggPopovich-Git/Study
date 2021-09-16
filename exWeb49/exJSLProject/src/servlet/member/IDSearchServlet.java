package servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDAO;

@WebServlet("/id_search")
public class IDSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public IDSearchServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Member/id_search.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		System.out.println(name);
		System.out.println(email);
		MemberDAO dao = MemberDAO.getInstance();
		String userid = dao.getID(name, email);
		int length = 0;
		if(!(userid == "")) {
			length = userid.length() - 3; // 세자리 제외 글자수
			userid = userid.substring(0,3); // 앞 세자리
		} else {
			userid = "x";
		}
		request.setAttribute("userid", userid);
		request.setAttribute("length", length);
		doGet(request, response);
	}

}
