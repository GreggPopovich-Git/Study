package MySample.servlet.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySample.model.notice.NoticeDAO;
import MySample.model.notice.NoticeVO;

@WebServlet("/notice_view.do")
public class NoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NoticeViewServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		NoticeDAO dao = NoticeDAO.getInstance();
		
		// 쿠키 검사
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int x = 0; x < cookies.length; x++) {
			info = cookies[x];
			if(info.getName().equals("Guest" + idx)) {
				bool = true;
				break;
			}
		}
		if(!bool) {
			String value = "" + System.currentTimeMillis();
			info = new Cookie("Notice" + idx, value);
			info.setMaxAge(24*60*60);
			response.addCookie(info);
			dao.noticeHit(idx); //조회수증가
		}
		
		NoticeVO vo = dao.getNotice(idx);
		vo.setIdx(idx);
		
		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("notice/notice_view.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
