package service.gallery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.gallery.GalleryDAO;
import service.CommandHandler;
import util.UserSHA256;

public class GalleryDeleteProHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pass = UserSHA256.getSHA256(request.getParameter("pass"));
		GalleryDAO dao = GalleryDAO.getInstance();
		int row = dao.galleryDelete(idx, pass);
		request.setAttribute("deleterow", row);
		return "/gallery/gallery_delete.jsp";
	}

}
