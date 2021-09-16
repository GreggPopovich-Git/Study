package service.pds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandHandler;

public class PdsWriteHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String nowpage=request.getParameter("page");
		request.setAttribute("page", nowpage);
		return "/Pds/pds_write.jsp";
	}

}
