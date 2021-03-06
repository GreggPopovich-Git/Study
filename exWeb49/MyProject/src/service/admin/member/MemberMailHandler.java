package service.admin.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import service.CommandHandler;

public class MemberMailHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		String users[] = request.getParameterValues("users");
		MemberDAO dao = MemberDAO.getInstance();
		List<String> list = new ArrayList<String>();
		List<String> user = new ArrayList<String>();
		for(int x = 0; x < users.length; x++) {
			if(!users[x].equals("selectall")) {
				user.add(users[x]);
			}
		}
		String mail = null;
		for(int x = 0; x < user.size(); x++) {
			mail = dao.getMember(user.get(x)).getEmail();
			list.add(mail);
		}
		request.setAttribute("email", list);
		return "/Admin/member_mail.jsp";
	}

}
