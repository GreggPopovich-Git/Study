package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.member.MemberDAO;
import model.member.MemberVO;
import service.CommandHandler;
import util.UserSHA256;

public class MemberInfoProHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
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
		int row = dao.memberModify(vo);
		request.setAttribute("row", row);
		if(row == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("sessionvo", vo);
		}
		return "/member/member_info.jsp";
	}

}
