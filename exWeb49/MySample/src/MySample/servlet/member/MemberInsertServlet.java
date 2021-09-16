package MySample.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MySample.model.member.MemberDAO;
import MySample.model.member.MemberVO;
import MySample.util.UserSHA256;

@WebServlet("/member.do")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberInsertServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("member/member.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberVO vo = new MemberVO();
		vo.setUserid(request.getParameter("userid"));
		vo.setPass(UserSHA256.getSHA256(request.getParameter("pass")));
		vo.setName(request.getParameter("name"));
		String email = "";
		if(request.getParameter("email2") == null) {
			email = request.getParameter("email1") + "@" + request.getParameter("domain");
		} else {
			email = request.getParameter("email1") + "@" + request.getParameter("email2");
		}
		vo.setEmail(email);
		String tel = request.getParameter("tel1") + "-" + request.getParameter("tel2") + "-" + request.getParameter("tel3");
		vo.setTel(tel);
		MemberDAO dao = MemberDAO.getInstance();
		int row = dao.memberInsert(vo);
		
		request.setAttribute("vo", vo);
		request.setAttribute("row", row);
		if(row == 1) {
			dao.lastTimeUpdate(vo.getUserid());
			HttpSession session = request.getSession();
			session.setAttribute("sessionvo", vo);
			session.setMaxInactiveInterval(1800); // 30분
		}
		doGet(request, response);
	}

}
