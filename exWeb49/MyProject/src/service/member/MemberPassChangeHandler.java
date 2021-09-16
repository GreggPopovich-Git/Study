package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import service.CommandHandler;
import util.UserSHA256;

public class MemberPassChangeHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int row = 99;
		System.out.println(request.getParameter("id"));
		if(request.getParameter("pass") != null) {
			String userid = request.getParameter("id");
			String pass = UserSHA256.getSHA256(request.getParameter("pass"));
			MemberDAO dao = MemberDAO.getInstance();
			row = dao.passModify(userid, pass);
		}
		request.setAttribute("row", row);
		request.setAttribute("key", request.getParameter("key"));
		request.setAttribute("userid", request.getParameter("id"));
		return "/member/newpass.jsp";
	}

}
