package exServletJSTL.servlet.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exServletJSTL.model.member.MemberDAO;
import exServletJSTL.model.member.MemberVO;

@WebServlet("/userinfo_list.do")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getInstance();
		List<MemberVO> list = dao.memberList();
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("Member/userinfo_list.jsp");
		rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDAO dao = MemberDAO.getInstance();
		String search = request.getParameter("search");
		String key = request.getParameter("key");
		List<MemberVO> list = dao.searchList(search, key);
		request.setAttribute("list", list);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		RequestDispatcher rd = request.getRequestDispatcher("Member/userinfo_list.jsp");
		rd.forward(request, response);
	}

}

