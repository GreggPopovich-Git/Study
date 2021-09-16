package service.admin.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.notice.NoticeDAO;
import model.notice.NoticeVO;
import service.CommandHandler;
import util.PageIndex;

public class NoticeListHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		NoticeDAO dao = NoticeDAO.getInstance();
		
		String s_query = "", search = "", key = "";
		String url = "admin_notice_list.do";
		int totcount = 0; // 게시글 총수
		if (request.getParameter("key") != null) {
			key = request.getParameter("key");
			search = request.getParameter("search");
			s_query = search + " like '%" + key + "%'";
			totcount = dao.noticeCount(s_query);
		} else {
			totcount = dao.noticeCount();
		}
		int nowpage = 1;
		int maxlist = 10;
		int totpage = 1;
		
		if(totcount % maxlist == 0) {
			totpage = totcount / maxlist;
		} else {
			totpage = totcount / maxlist + 1;
		}
		
		// 페이지 번호 클릭 했을 때
		if (request.getParameter("page") != null) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		}
		
		int startpage = (nowpage - 1) * maxlist + 1;
		int endpage = nowpage * maxlist;
		int listcount = totcount - ((nowpage - 1) * maxlist); // list에서 번호출력용
		
		List<NoticeVO> list = null;
		if(key.equals("")) {
			list = dao.noticeList(startpage, endpage);
		} else {
			list = dao.noticeList(s_query, startpage, endpage);
		}
		// 페이징 처리
		String pageSkip = "";
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, url, "");
		} else {
			pageSkip = PageIndex.pageListHan(nowpage, totpage, url, search, key);
		}
		request.setAttribute("listcount", listcount);
		request.setAttribute("page", nowpage);
		request.setAttribute("totcount", totcount);
		request.setAttribute("totpage", totpage);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		
		return "/Admin/notice_list.jsp";
	}

}