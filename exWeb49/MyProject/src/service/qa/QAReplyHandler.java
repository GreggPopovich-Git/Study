package service.qa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.qa.QADAO;
import model.qa.QAVO;
import service.CommandHandler;

public class QAReplyHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx"));
		QADAO dao = QADAO.getInstance();
		QAVO vo = dao.getQA(idx);
		request.setAttribute("vo", vo);
		request.setAttribute("idx", idx);
		return "/qa/qareply.jsp";
	}

}
