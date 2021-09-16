package servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDAO;
import model.vo.MemberVO;
import util.UserSHA256;

@WebServlet("/member_modify")
public class MemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberModifyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/Member/member_modify.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberVO beforeVO = (MemberVO)session.getAttribute("vo"); // 기존 회원정보
		
		MemberVO vo = new MemberVO(); // 새로운 회원 정보
		vo.setUserid(request.getParameter("userid"));
		vo.setName(request.getParameter("name"));
		String pass = UserSHA256.getSHA256(request.getParameter("pass"));
		vo.setPass(pass);
		vo.setGender(request.getParameter("gender"));
		vo.setTel(request.getParameter("tel"));
		vo.setEmail(request.getParameter("email"));
		
		MemberDAO dao = MemberDAO.getInstance();
		int row = 0;
		if(beforeVO.getPass().equals(pass)) { // 비밀번호 비교
			row = 3; // 비밀번호 일치 할 때
			dao.memberModify(vo);
			session.setAttribute("vo", vo);
		} else {
			row = 0; // 비밀번호 틀릴 때
		}
		response.sendRedirect("index?row=" + row);
	}

}
