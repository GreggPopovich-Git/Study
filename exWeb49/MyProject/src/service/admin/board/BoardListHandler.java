package service.admin.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;
import service.CommandHandler;
import util.PageIndex;

public class BoardListHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		BoardDAO dao = BoardDAO.getInstance();
		
		String s_query = "", search = "", key = "";
		String url = "admin_board_list.do";
		int totcount = 0; // 게시글 총수
		if (request.getParameter("key") != null) {
			key = request.getParameter("key");
			search = request.getParameter("search");
			s_query = search + " like '%" + key + "%'";
			totcount = dao.boardCount(s_query);
		} else {
			totcount = dao.boardCount();
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
		
		List<BoardVO> list = null;
		if(key.equals("")) {
			list = dao.boardList(startpage, endpage);
		} else {
			list = dao.boardList(s_query, startpage, endpage);
		}
		// 페이징 처리
		String pageSkip = "";
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, url, "");
		} else {
			pageSkip = PageIndex.pageListHan(nowpage, totpage, url, search, key);
		}
		
		int listcount = list.size();
		
		request.setAttribute("listcount", listcount);
		request.setAttribute("page", nowpage);
		request.setAttribute("totcount", totcount);
		request.setAttribute("totpage", totpage);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		
		return "/Admin/board_list.jsp";
	}

}
