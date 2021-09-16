package service.notice;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.notice.NoticeDAO;
import model.notice.NoticeVO;
import service.CommandHandler;

public class NoticeWriteProHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
request.setCharacterEncoding("utf-8");
		
		ServletContext context = request.getServletContext();
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
		return "/notice/notice_write.jsp";
	}

}
