package service.pds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandHandler;

public class PdsDeleteHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String nowpage = request.getParameter("page");
		
		request.setAttribute("idx", idx);
		request.setAttribute("page", nowpage);
		
		return "/Pds/pds_delete.jsp";
	}

}
