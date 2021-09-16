package servlet.pds;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.PdsDAO;
import model.vo.MemberVO;
import model.vo.PdsVO;

@WebServlet("/pds_modify")
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
		HttpSession session = request.getSession();
		MemberVO membervo = (MemberVO)session.getAttribute("vo");
		
		int result = 0;
		if(vo.getUserid().equals(membervo.getUserid())) { // 글을 쓴 본인인지 확인과정
			result = 1; // 본인일 경우
		} else {
			result = -1; // 본인이 아닌 경우
		}
		
		request.setAttribute("vo", vo);
		request.setAttribute("length", vo.getContents().length());
		request.setAttribute("page", page);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_modify.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String page = request.getParameter("page");
		ServletContext context = getServletContext();
		String path = context.getRealPath("Pds/upload");
		String encType = "UTF-8";
		int sizeLimit = 2 * 1024 * 1024; // 파일 최대 용량(2M)
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		PdsVO vo = new PdsVO();
		vo.setIdx(Integer.parseInt(multi.getParameter("idx")));
		vo.setName(multi.getParameter("name"));
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
		
		PdsDAO dao = PdsDAO.getInstance();
		int row = dao.pdsModify(vo);
		
		response.sendRedirect("pds_view?page=" + page + "&idx=" + vo.getIdx());
	}

}
