package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import service.CommandHandler;

public class MemberIDCheckProHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String userid = request.getParameter("userid");
		MemberDAO dao = MemberDAO.getInstance();
		int row = dao.idcheck(userid);
		request.setAttribute("userid", userid);
		request.setAttribute("row", row);
		return "/member/idcheck.jsp";
	}

}
