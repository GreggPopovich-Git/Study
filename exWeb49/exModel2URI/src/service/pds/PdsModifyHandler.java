package service.pds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.pds.PdsDAO;
import model.pds.PdsVO;
import service.CommandHandler;

public class PdsModifyHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String nowpage=request.getParameter("page");

		PdsDAO pDAO = PdsDAO.getInstance();

		PdsVO pds = pDAO.selectPdsNum(idx);
		request.setAttribute("pds", pds);
		request.setAttribute("page", nowpage);
		return "/Pds/pds_modify.jsp";
	}

}
