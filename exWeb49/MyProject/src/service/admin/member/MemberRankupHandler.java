package service.admin.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import service.CommandHandler;

public class MemberRankupHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String users[] = request.getParameterValues("users");
		MemberDAO dao = MemberDAO.getInstance();
		List<String> list = new ArrayList<String>();
		for(int x = 0; x < users.length; x++) {
			if(!users[x].equals("selectall")) {
				list.add(users[x]);
			}
		}
		int[] row = new int[list.size()];
		for(int x = 0; x < list.size(); x++) {
			row[x] = dao.userRankUp(list.get(x));
		}
		
		request.setAttribute("row", row);
		return "/Admin/member_delete.jsp";
	}

}
