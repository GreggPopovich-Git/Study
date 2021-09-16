package MySample.servlet.qa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySample.model.qa.QADAO;
import MySample.model.qa.QAVO;

@WebServlet("/qaview.do")
public class QAViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public QAViewServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		RequestDispatcher rd = request.getRequestDispatcher("qa/qaview.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
