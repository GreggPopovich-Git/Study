package exServletJSTL.servlet.pds;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exServletJSTL.model.pds.PdsDAO;
import exServletJSTL.model.pds.PdsVO;

@WebServlet("/pds_delete.do")
public class PdsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PdsDeleteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_delete.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		String pass = request.getParameter("pass");
		ServletContext context = getServletContext();
		String path = context.getRealPath("Pds/upload");
		PdsDAO dao = PdsDAO.getInstance();
		PdsVO vo = dao.getPds(idx);
		int row = dao.pdsDelete(idx, pass);
		if(row == 1) {
			String oldfilename = vo.getFilename();
			if(oldfilename != null) {
				File file = new File(path, oldfilename);
				if(file.exists()) {
					file.delete();
				}
			}
		}
		request.setAttribute("idx", idx);
		request.setAttribute("page", page);
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_delete.jsp");
		rd.forward(request, response);
		
	}

}
