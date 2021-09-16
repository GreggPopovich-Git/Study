package service.notice;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.notice.NoticeDAO;
import model.notice.NoticeVO;
import service.CommandHandler;

public class NoticeViewHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
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
		return "/notice/notice_view.jsp";
	}

}
