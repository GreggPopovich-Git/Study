package service.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.notice.NoticeDAO;
import model.notice.NoticeVO;
import service.CommandHandler;

public class NoticeModifyHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeVO vo = dao.getNotice(Integer.parseInt(request.getParameter("idx")));
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		request.setAttribute("vo", vo);
		return "/notice/notice_modify.jsp";
	}

}
