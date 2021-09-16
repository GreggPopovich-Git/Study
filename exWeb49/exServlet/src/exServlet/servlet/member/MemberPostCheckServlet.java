package exServlet.servlet.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exServlet.model.member.MemberDAO;
import exServlet.model.member.ZipVO;

@WebServlet("/post_check")
public class MemberPostCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberPostCheckServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("Member/post_check.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String addr = request.getParameter("addr");
		MemberDAO dao = MemberDAO.getInstance();
		List<ZipVO> zlist = dao.zipList(addr);
		request.setAttribute("zlist", zlist);
		
		doGet(request, response);
	}

}
