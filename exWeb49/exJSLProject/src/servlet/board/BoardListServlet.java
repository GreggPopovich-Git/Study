package servlet.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDAO;
import model.vo.BoardVO;
import util.PageIndex;

@WebServlet("/board_list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getInstance();
		int row = 0;
		if(request.getParameter("row") != null) {
			row = Integer.parseInt(request.getParameter("row"));
		}
		String sort = "";
		if(request.getParameter("sort") != null) {
			sort = request.getParameter("sort");
		} else {
			sort = "order by regdate desc";
		}
		String s_query = "", search = "", key = "";
		String url = "board_list";
		int totcount = 0; // 게시글 총수
		if (row == 1) {
			key = request.getParameter("key");
			search = request.getParameter("search");
			s_query = search + " like '%" + key + "%'";
			totcount = dao.boardCount(s_query); // 검색 했을 때
		} else {
			totcount = dao.boardCount(); // 검색 안했을 때
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
		if (request.getParameter("totpage") != null) {
			totpage = Integer.parseInt(request.getParameter("totpage"));
		}
		int startpage = (nowpage - 1) * maxlist + 1;
		int endpage = nowpage * maxlist;
		int listcount = totcount - ((nowpage - 1) * maxlist); // list에서 번호출력용
		
		List<BoardVO> list = null;
		if(key.equals("")) {
			list = dao.boardList(startpage, endpage, sort); // 검색 안했을 때
		} else {
			list = dao.boardList(s_query, startpage, endpage, sort); // 검색 했을 때
		}
		// 페이징 처리
		String pageSkip = "";
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, url, "", sort, 0);
		} else {
			pageSkip = PageIndex.pageListHan(nowpage, totpage, url, search, key, sort);
		}
		request.setAttribute("sort", sort);
		request.setAttribute("row", row);
		request.setAttribute("page", nowpage);
		request.setAttribute("totcount", totcount);
		request.setAttribute("totpage", totpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		RequestDispatcher rd = request.getRequestDispatcher("Board/board_list.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
