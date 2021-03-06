package exServletJSTL.servlet.gallery;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exServletJSTL.model.gallery.GalleryDAO;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/gallery_delete.do")
public class GalleryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GalleryDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));				
		
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		RequestDispatcher dispater = 
				request.getRequestDispatcher("Gallery/gallery_delete.jsp");
		dispater.forward(request, response);

		//response.sendRedirect("board_list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		String pass = request.getParameter("pass");
		
		GalleryDAO dao = GalleryDAO.getInstance();
		int row = dao.galleryDelete(idx,pass);
		
		request.setAttribute("row", row);
		request.setAttribute("page", page);

		RequestDispatcher dispater = 
				request.getRequestDispatcher("Gallery/gallery_delete_pro.jsp");
		dispater.forward(request, response);

		//response.sendRedirect("board_list");
		
	}

}
