package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandHandler;

public class MemberInsertHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		return "/member/member.jsp";
	}

}
