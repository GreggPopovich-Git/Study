package service.gallery;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.gallery.GalleryDAO;
import model.gallery.GalleryVO;
import service.CommandHandler;

public class GalleryViewHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx"));
		GalleryDAO dao = GalleryDAO.getInstance();
		// 쿠키 검사
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int x = 0; x < cookies.length; x++) {
			info = cookies[x];
			if(info.getName().equals("Guest" + idx)) {
				bool = true;
				break;
			}
		}
		if(!bool) {
			String value = "" + System.currentTimeMillis();
			info = new Cookie("Guest" + idx, value);
			info.setMaxAge(24*60*60);
			response.addCookie(info);
			dao.GalleryHit(idx); //조회수증가
		}
		GalleryVO vo = dao.getGallery(idx);
		vo.setIdx(idx);
		
		request.setAttribute("vo", vo);
		return "/gallery/gallery_view.jsp";
	}

}
