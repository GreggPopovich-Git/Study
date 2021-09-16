package MySample.servlet.gallery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySample.model.gallery.GalleryDAO;
import MySample.model.gallery.GalleryVO;
import MySample.util.PageIndex;

@WebServlet("/gallery.do")
public class GalleryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GalleryListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String type = "";
		if(request.getParameter("type") != null) { 
			type = request.getParameter("type");
		}
		GalleryDAO dao = GalleryDAO.getInstance();
		
		String s_query = "", search = "", key = "";
		String url = "gallery.do";
		int totcount = 0; // 게시글 총수
		if (request.getParameter("key") != null) {
			key = request.getParameter("key");
			search = request.getParameter("search");
			if(request.getParameter("type") == null) {
				s_query = search + " like '%" + key + "%'";
			} else {
				s_query = search + " like '%" + key + "%' and type='" + type + "'";
			}
			totcount = dao.galleryCount(s_query);
		} else {
			if(request.getParameter("type") == null) {
				totcount = dao.galleryCount();
			} else {
				s_query = "type='" + type + "'";
				totcount = dao.galleryCount(s_query);
			}
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
		
		List<GalleryVO> list = null;
		if(key.equals("")) {
			if(request.getParameter("type") == null) {
				list = dao.galleryList(startpage, endpage);
			} else {
				list = dao.galleryList(s_query, startpage, endpage);
			}
		} else {
			list = dao.galleryList(s_query, startpage, endpage);
		}
		// 페이징 처리
		String pageSkip = "";
		if(request.getParameter("type") == null ) {
			if(key.equals("")) {
				pageSkip = PageIndex.pageList(nowpage, totpage, url, "");
			} else {
				pageSkip = PageIndex.pageListHan(nowpage, totpage, url, search, key);
			}
		} else {
			if(key.equals("")) {
				pageSkip = PageIndex.pageList(nowpage, totpage, url, "", type);
			} else {
				pageSkip = PageIndex.pageListHan(nowpage, totpage, url, search, key, type);
			}
		}
		String target = "src=";
		List<String> path = new ArrayList<String>();
		for(int x = 0; x < list.size(); x++) {
			String contents = list.get(x).getContents();
			int target_num = contents.indexOf(target);
			String result = contents.substring(target_num,(contents.substring(target_num).indexOf(" ")+target_num));
			path.add(result);
		}
		String style = "";
		if(list.size() <= 4) {
			style = "style='width:" + ((list.size() - (((list.size()-1) / 4) * 4)) * 300) + "px;'";
		} else {
			style = "style='width:1200px;'";
		}
		
		request.setAttribute("style", style);
		request.setAttribute("path", path);
		request.setAttribute("page", nowpage);
		request.setAttribute("totcount", totcount);
		request.setAttribute("totpage", totpage);
		request.setAttribute("list", list);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		
		RequestDispatcher rd = request.getRequestDispatcher("/gallery/gallery.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
