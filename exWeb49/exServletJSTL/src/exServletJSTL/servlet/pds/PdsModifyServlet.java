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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import exServletJSTL.model.pds.PdsDAO;
import exServletJSTL.model.pds.PdsVO;

@WebServlet("/pds_modify.do")
public class PdsModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PdsModifyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		PdsDAO dao = PdsDAO.getInstance();
		
		PdsVO vo = dao.getPds(idx);
		vo.setIdx(idx);
		request.setAttribute("page", page);
		request.setAttribute("vo", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_modify.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ServletContext context = getServletContext();
		String path = context.getRealPath("Pds/upload");
		String encType = "UTF-8";
		int sizeLimit = 2 * 1024 * 1024; // 파일 최대 용량(2M)
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		PdsVO vo = new PdsVO();
		vo.setIdx(Integer.parseInt(multi.getParameter("idx")));
		vo.setName(multi.getParameter("name"));
		vo.setPass(multi.getParameter("pass"));
		vo.setEmail(multi.getParameter("email"));
		vo.setSubject(multi.getParameter("subject"));
		vo.setContents(multi.getParameter("contents"));
		vo.setFilename(multi.getFilesystemName("filename"));
		String oldfilename = multi.getParameter("oldfilename");
		
		if(vo.getFilename() == null) {
			vo.setFilename(oldfilename);
		} else {
			File file = new File(path, oldfilename);
			if(file.exists()) {
				file.delete();
			}
		}
		int page = Integer.parseInt(multi.getParameter("page"));
		PdsDAO dao = PdsDAO.getInstance();
		int row = dao.pdsModify(vo);
		
		response.sendRedirect("pds_view.do?page=" + page + "&idx=" + vo.getIdx() + "&row=" + row);
	}

}
