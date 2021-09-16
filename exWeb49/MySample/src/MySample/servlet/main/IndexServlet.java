package MySample.servlet.main;

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
import MySample.model.notice.NoticeDAO;
import MySample.model.notice.NoticeVO;

@WebServlet("/index.do")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public IndexServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GalleryDAO gdao = GalleryDAO.getInstance();
		List<GalleryVO> glist = new ArrayList<GalleryVO>();
		glist = gdao.galleryList(1, 3);
		String target = "src=";
		List<String> path = new ArrayList<String>();
		for(int x = 0; x < glist.size(); x++) {
			String contents = glist.get(x).getContents();
			int target_num = contents.indexOf(target);
			String result = contents.substring(target_num,(contents.substring(target_num).indexOf(" ")+target_num));
			path.add(result);
		}
		NoticeDAO noticedao = NoticeDAO.getInstance();
		List<NoticeVO> noticelist = noticedao.noticeList(1, 5);
		request.setAttribute("nlist", noticelist);
		request.setAttribute("path", path);
		request.setAttribute("glist", glist);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
