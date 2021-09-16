package MySample.servlet.notice;

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

import MySample.model.notice.NoticeDAO;
import MySample.model.notice.NoticeVO;

@WebServlet("/notice_write.do")
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NoticeWriteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("notice/notice_write.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("notice/upload");
		String encType = "UTF-8";
		int sizeLimit = 2 * 1024 * 1024; // 파일 최대 용량(2M)
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		NoticeVO vo = new NoticeVO();
		vo.setUserid(multi.getParameter("userid"));
		vo.setName(multi.getParameter("name"));
		vo.setBoardtype(multi.getParameter("boardtype"));
		vo.setSubject(multi.getParameter("subject"));
		vo.setContents(multi.getParameter("contents"));
		vo.setFilename(multi.getFilesystemName("filename"));
		
		NoticeDAO dao = NoticeDAO.getInstance();
		int noticerow = dao.noticeWrite(vo);
		
		request.setAttribute("noticerow", noticerow);
		doGet(request, response);
	}

}
