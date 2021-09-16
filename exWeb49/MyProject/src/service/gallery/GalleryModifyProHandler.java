package service.gallery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.gallery.GalleryDAO;
import model.gallery.GalleryVO;
import service.CommandHandler;
import util.UserSHA256;

public class GalleryModifyProHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
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
		return "/gallery/gallery_modify.jsp";
	}

}
