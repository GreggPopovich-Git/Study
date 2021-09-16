package servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDAO;
import util.UserSHA256;

@WebServlet("/member_delete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberDeleteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Member/member_view.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String pass = UserSHA256.getSHA256(request.getParameter("nowpass"));
		MemberDAO dao = MemberDAO.getInstance();
		ServletContext context = getServletContext();
		String path = context.getRealPath("Pds/upload");
		int row = dao.memberDelete(userid, pass, path); // 삭제 되면 1, 아니면 0
		
		if(row == 1) {
			response.sendRedirect("logout");
		} else {
			response.sendRedirect("member_view?row=" + row);
		}
		
	}

}
