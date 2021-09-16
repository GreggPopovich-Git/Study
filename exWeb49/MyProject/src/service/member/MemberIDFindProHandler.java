package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import service.CommandHandler;

public class MemberIDFindProHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
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
		return "/member/idfind.jsp";
	}

}
