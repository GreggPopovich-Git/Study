package service.qa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.notice.NoticeDAO;
import model.notice.NoticeVO;
import model.qa.QADAO;
import model.qa.QAVO;
import service.CommandHandler;
import util.PageIndex;

public class QAListHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		QADAO dao = QADAO.getInstance();
		
		String s_query = "", search = "", key = "";
		String url = "qa.do";
		int totcount = 0; // 게시글 총수
		if (request.getParameter("key") != null) {
			key = request.getParameter("key");
			search = request.getParameter("search");
			s_query = search + " like '%" + key + "%'";
			totcount = dao.qaCount(s_query);
		} else {
			totcount = dao.qaCount();
		}
		int nowpage = 1;
		int maxlist = 12;
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
		
		List<QAVO> list = null;
		if(key.equals("")) {
			list = dao.qaList(startpage, endpage);
		} else {
			list = dao.qaList(s_query, startpage, endpage);
		}
		// 페이징 처리
		String pageSkip = "";
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, url, "");
		} else {
			pageSkip = PageIndex.pageListHan(nowpage, totpage, url, search, key);
		}
		
		int listcount = list.size();
		
		NoticeDAO noticedao = NoticeDAO.getInstance();
		String notice_s_query = " boardtype = 'qa'";
		List<NoticeVO> noticelist = noticedao.noticeList(notice_s_query, 1, 2);
		
		request.setAttribute("noticelist", noticelist);
		request.setAttribute("listcount", listcount);
		request.setAttribute("page", nowpage);
		request.setAttribute("totcount", totcount);
		request.setAttribute("totpage", totpage);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		return "/qa/qa.jsp";
	}

}
