package service.qa;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.qa.QADAO;
import model.qa.QAVO;
import service.CommandHandler;

public class QAViewHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx"));
		QADAO dao = QADAO.getInstance();
		QAVO vo = dao.getQA(idx);
		// 쿠키 검사
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int x = 0; x < cookies.length; x++) {
			info = cookies[x];
			if(info.getName().equals("qa" + idx)) {
				bool = true;
				break;
			}
		}
		if(!bool) {
			String value = "" + System.currentTimeMillis();
			info = new Cookie("qa" + idx, value);
			info.setMaxAge(24*60*60);
			response.addCookie(info);
			dao.qaHit(idx); //조회수증가
		}
		request.setAttribute("idx", idx);
		request.setAttribute("vo", vo);
		return "/qa/qaview.jsp";
	}

}
