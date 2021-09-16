package servlet.pds;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.PdsDAO;
import model.vo.PdsVO;
import util.PageIndex;

@WebServlet("/pds_list")
public class PdsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PdsListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = 0;
		if(request.getParameter("idx") != null) {
			idx = Integer.parseInt(request.getParameter("idx"));
		}
		PdsDAO dao = PdsDAO.getInstance();
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
		String url = "pds_list";
		int totcount = 0; // 게시글 총수
		if (row == 1) {
			key = request.getParameter("key");
			search = request.getParameter("search");
			s_query = search + " like '%" + key + "%'";
			totcount = dao.pdsCount(s_query); // 검색 했을 때
		} else {
			totcount = dao.pdsCount(); // 검색 안했을 때
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
		
		List<PdsVO> list = null;
		if(key.equals("")) {
			list = dao.pdsList(startpage, endpage, sort); // 검색 안했을 때
		} else {
			list = dao.pdsList(s_query, startpage, endpage, sort); // 검색 했을 때
		}
		// 페이징 처리
		String pageSkip = "";
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, url, "", sort, idx);
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
		
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_list.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
