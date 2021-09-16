package service.notice;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.notice.NoticeDAO;
import model.notice.NoticeVO;
import service.CommandHandler;

public class NoticeModifyProHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("notice/upload");
		String encType = "UTF-8";
		int sizeLimit = 2 * 1024 * 1024; // 파일 최대 용량(2M)
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		NoticeVO vo = new NoticeVO();
		vo.setIdx(Integer.parseInt(multi.getParameter("idx")));
		vo.setUserid(multi.getParameter("userid"));
		vo.setName(multi.getParameter("name"));
		vo.setSubject(multi.getParameter("subject"));
		vo.setBoardtype(multi.getParameter("boardtype"));
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
		NoticeDAO dao = NoticeDAO.getInstance();
		int row = dao.noticeModify(vo);
		request.setAttribute("vo", vo);
		request.setAttribute("modifyrow", row);
		
		return "/notice/notice_modify.jsp";
	}

}
