package service.gallery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.gallery.GalleryDAO;
import model.gallery.GalleryVO;
import service.CommandHandler;

public class GalleryModifyHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		GalleryDAO dao = GalleryDAO.getInstance();
		GalleryVO vo = dao.getGallery(Integer.parseInt(request.getParameter("idx")));
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		request.setAttribute("vo", vo);
		return "/gallery/gallery_modify.jsp";
	}

}
