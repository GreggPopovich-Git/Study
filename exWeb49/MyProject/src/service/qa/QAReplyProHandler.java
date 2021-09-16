package service.qa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.qa.QADAO;
import model.qa.QAVO;
import service.CommandHandler;

public class QAReplyProHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		String answer = request.getParameter("answer");
		
		QADAO dao = QADAO.getInstance();
		QAVO vo = new QAVO();
		vo.setIdx(idx);
		vo.setAnswer(answer);
		int row = dao.qaModify(vo);
		System.out.println(row);
		request.setAttribute("idx", idx);
		request.setAttribute("answerrow", row);
		
		return "/qa/qareply.jsp";
	}

}
