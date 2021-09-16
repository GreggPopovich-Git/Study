package MySample.servlet.gallery;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySample.model.gallery.GalleryDAO;
import MySample.util.UserSHA256;

@WebServlet("/gallery_delete.do")
public class GalleryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GalleryDeleteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		request.setAttribute("idx", idx);
		RequestDispatcher rd = request.getRequestDispatcher("gallery/gallery_delete.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pass = UserSHA256.getSHA256(request.getParameter("pass"));
		GalleryDAO dao = GalleryDAO.getInstance();
		int row = dao.galleryDelete(idx, pass);
		request.setAttribute("deleterow", row);
		
		doGet(request, response);
	}

}
