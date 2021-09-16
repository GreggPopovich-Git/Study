package MySample.servlet.gallery;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MySample.model.gallery.GalleryDAO;
import MySample.model.gallery.GalleryVO;
import MySample.model.member.MemberVO;
import MySample.util.UserSHA256;

@WebServlet("/gallery_write.do")
public class GalleryWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GalleryWriteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("gallery/gallery_write.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		doGet(request, response);
	}

}
