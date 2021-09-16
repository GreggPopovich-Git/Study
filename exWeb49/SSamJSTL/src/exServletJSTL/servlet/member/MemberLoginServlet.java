package exServletJSTL.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exServletJSTL.model.member.MemberDAO;
import exServletJSTL.model.member.MemberVO;


/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/userlogin.do")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("Member/userlogin_form.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Member/userlogin_ok.jsp";
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		
		MemberDAO dao = MemberDAO.getInstance();
		int row = dao.memberLogin(userid, passwd);
		//request.setAttribute("row", row);
		if (row == 1) {
			MemberVO vo = dao.memberSelect(userid);//이름, 아이디, 별칭
			HttpSession session = request.getSession();
			session.setAttribute("user", vo);
			session.setMaxInactiveInterval(1800);
			request.setAttribute("message", "로그인 성공했습니다.");
			//url = "Member/userlogin_ok.jsp";
			response.sendRedirect("index.do");
		}

		//RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		//dispatcher.forward(request, response);

	}

}
