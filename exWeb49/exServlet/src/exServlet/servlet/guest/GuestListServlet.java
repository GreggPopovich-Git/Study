package exServlet.servlet.guest;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exServlet.model.guest.GuestDAO;
import exServlet.model.guest.GuestVO;
import exServlet.util.PageIndex;

@WebServlet("/guest_list")
public class GuestListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GuestListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestDAO dao = GuestDAO.getInstance();
		
		String s_query = "", search = "", key = "";
		String url = "guest_list";
		int totcount = 0; // 게시글 총수
		if (request.getParameter("key") != null) {
			key = request.getParameter("key");
			search = request.getParameter("search");
			s_query = search + " like '%" + key + "%'";
			totcount = dao.guestCount(s_query);
		} else {
			totcount = dao.guestCount();
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
		
		List<GuestVO> list = null;
		if(key.equals("")) {
			list = dao.guestList(startpage, endpage);
		} else {
			list = dao.guestList(s_query, startpage, endpage);
		}
		// 페이징 처리
		String pageSkip = "";
		if(key.equals("")) {
			pageSkip = PageIndex.pageList(nowpage, totpage, url, "");
		} else {
			pageSkip = PageIndex.pageListHan(nowpage, totpage, url, search, key);
		}
		
		request.setAttribute("page", nowpage);
		request.setAttribute("totcount", totcount);
		request.setAttribute("totpage", totpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_list.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
