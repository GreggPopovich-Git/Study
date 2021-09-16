package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.member.MemberDAO;
import model.member.MemberVO;
import service.CommandHandler;
import util.UserSHA256;

public class MemberLoginProHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String userid = request.getParameter("userid");
		String pass = UserSHA256.getSHA256(request.getParameter("pass"));
		MemberDAO dao = MemberDAO.getInstance();
		int row = dao.userLogin(userid, pass);
		if(row == 1) {
			MemberVO vo = dao.getMember(userid);
			HttpSession session = request.getSession();
			session.setAttribute("sessionvo", vo);
			session.setMaxInactiveInterval(1800); // 30분
		}
		request.setAttribute("row", row);
		return "/member/login.jsp";
	}

}
