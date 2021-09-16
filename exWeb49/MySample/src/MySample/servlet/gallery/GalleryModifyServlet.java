package MySample.servlet.gallery;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySample.model.gallery.GalleryDAO;
import MySample.model.gallery.GalleryVO;
import MySample.util.UserSHA256;

@WebServlet("/gallery_modify.do")
public class GalleryModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GalleryModifyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GalleryDAO dao = GalleryDAO.getInstance();
		GalleryVO vo = dao.getGallery(Integer.parseInt(request.getParameter("idx")));
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("gallery/gallery_modify.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		GalleryVO vo = new GalleryVO();
		int row = 0;
		if(request.getParameter("name") != null) {
			vo.setIdx(Integer.parseInt(request.getParameter("idx")));
			vo.setName(request.getParameter("name"));
			vo.setPass(UserSHA256.getSHA256(request.getParameter("pass")));
			vo.setSubject(request.getParameter("subject"));
			vo.setContents(request.getParameter("contents"));
			if(request.getParameter("contents").contains("src=")) {
				GalleryDAO dao = GalleryDAO.getInstance();
				row = dao.galleryModify(vo);
			} else {
				row = -1;
			}
		} else {
			row = -2;
		}
		request.setAttribute("idx", vo.getIdx());
		request.setAttribute("modifyrow", row);
		RequestDispatcher rd = request.getRequestDispatcher("gallery/gallery_modify.jsp");
		rd.forward(request, response);
	}

}
