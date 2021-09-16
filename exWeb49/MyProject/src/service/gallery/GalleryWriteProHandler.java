package service.gallery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.gallery.GalleryDAO;
import model.gallery.GalleryVO;
import model.member.MemberVO;
import service.CommandHandler;
import util.UserSHA256;

public class GalleryWriteProHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int row = 0;
		GalleryVO vo = new GalleryVO();
		if(session.getAttribute("sessionvo") != null) {
			MemberVO member = new MemberVO();
			member = (MemberVO)session.getAttribute("sessionvo");
			vo.setUserid(member.getUserid());
		}
		if(request.getParameter("name") != null) {
			vo.setName(request.getParameter("name"));
			vo.setPass(UserSHA256.getSHA256(request.getParameter("pass")));
			vo.setSubject(request.getParameter("subject"));
			vo.setContents(request.getParameter("contents"));
			vo.setType(request.getParameter("type"));
			if(request.getParameter("contents").contains("src=")) {
				GalleryDAO dao = GalleryDAO.getInstance();
				row = dao.galleryWrite(vo);
			} else {
				row = -1;
			}
		} else {
			row = -2;
		}
		request.setAttribute("writerow", row);
		return "/gallery/gallery_write.jsp";
	}

}
